package beans;

import java.io.Serializable;
import java.util.Properties;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.AllAds;

@ManagedBean(name = "sendEmail")
@SessionScoped
public class SendEmail implements Serializable{

    private String header;
    private String name;
    private String mailAddress;
    private AllAds selectedEmailAd = new AllAds();

@Inject
private LoginBean loginBean;
    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mailAddress
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * @param mailAddress the mailAddress to set
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    

    public void sendMail() {
        String EmailAdd = selectedEmailAd.getEmail();
        final String username = "realestategju@gmail.com";
        final String password = "realestateproject";
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {//EmailAdd
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("aaa@aaa.lt"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("justinasin@gmail.com"));
            message.setSubject("Real Estate Project");
            message.setText( loginBean.getUsername() + " send you the message from " + " with text: \n" + header);
            Transport.send(message);
        } catch (MessagingException ex) {
            throw new RuntimeException(ex);

        }
    }

    /**
     * @return the selectedCommentAd
     */
    public AllAds getSelectedEmailAd() {
        return selectedEmailAd;
    }

    
    public void setSelectedEmailAd(AllAds selectedEmailAd) {
        this.selectedEmailAd = selectedEmailAd;
    }

}