package br.com.dbc.vemcer.pessoaapi.service;

import br.com.dbc.vemcer.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemcer.pessoaapi.entity.Pessoa;
import freemarker.core.Environment;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String email;
    @Value("${spring.mail.username}")
    private String from;
    private String to = "shaienne.oliveira@dbccompany.com.br";

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("Assunto TESTE");
        message.setText("Meu e-mail Chegou!");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws Exception {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(message,
                    true);
        } catch (MessagingException e) {
            throw new Exception(e.getMessage());
        }

        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Assunto 1");
        mimeMessageHelper.setText("Meu e-mail!");

//        File file = new File("static/imagem.jpg");
//        FileSystemResource fileSr
//                = new FileSystemResource(file);
//        mimeMessageHelper.addAttachment(file.getName(), fileSr);

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("static/imagem.jpg").getFile());
        FileSystemResource fileRs = new FileSystemResource(file);
        mimeMessageHelper.addAttachment(file.getName(), fileRs);

        System.out.println("File: " + file.getPath());

        emailSender.send(message);
    }

    public void sendEmail(String content) throws Exception {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Assunto Teste Template");
            mimeMessageHelper.setText(content, true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new Exception("Erro ao enviar e-mail: " + e.getMessage());
        }
    }
    public String geContentFromTemplate(String acao, String entidade, Integer id) throws IOException, TemplateException {
        String templateName;

        switch (acao.toUpperCase()) {
            case "POST":
                templateName = "POST-" + entidade.toLowerCase() + "-email-template.ftl";
                break;
            case "PUT":
                templateName = "PUT-" + entidade.toLowerCase() + "-email-template.ftl";
                break;
            case "DELETE":
                templateName = "DELETE-" + entidade.toLowerCase() + "-email-template.ftl";
                break;
            case "GET":
                templateName = "GET-" + entidade.toLowerCase() + "-email-template.ftl";
                break;
            default:
                throw new IllegalArgumentException("Ação desconhecida: " + acao);
        }

        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Shaienne");
        dados.put("email", email);

        if ("PESSOA".equalsIgnoreCase(entidade) && id != null) {
            dados.put("id", id);
        }

        Template template = fmConfiguration.getTemplate(templateName);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }


}
