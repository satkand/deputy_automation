package utilities;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FromTerm;
import javax.mail.search.SubjectTerm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mailValidation {
	
	//Searching for received mail using IMAP server.
 

	public String getUrl() throws Exception {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "sattester7@gmail.com", "nokia@123");

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);

            System.out.println("Total Message:" + folder.getMessageCount());
            System.out.println("Unread Message:" + folder.getUnreadMessageCount());
            
            Message[] messages = null;
            boolean isMailFound = false;
            Message mailFromDeputy= null;

            //Search for mail from Deputy
            for (int i = 0; i <= 5; i++) {
                messages = folder.search(new SubjectTerm("Setup your deputy account"),
                        folder.getMessages());
                //Wait for 10 seconds
                if (messages.length == 0) {
                    Thread.sleep(10000);
                }
            }

            //Search for unread mail from Deputy
            //This is to avoid using the mail for which registration is already done
            for (Message mail : messages) {
                if (!mail.isSet(Flags.Flag.SEEN)) {
                    mailFromDeputy = mail;
                    System.out.println("Message Count is: "
                            + mailFromDeputy.getMessageNumber());
                    isMailFound = true;
                }
            }

            //Test fails if no unread mail was found from Deputy
            if (!isMailFound) {
                throw new Exception(
                        "Could not find new mail from Deputy :-(");
            
            //Read the content of mail and launch registration URL                
            } else {
                String line;
                StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(mailFromDeputy
                                .getInputStream()));
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                    
                }
                
               /* System.out.println(buffer);
                 
                 //Logic to split the message and get the Registration URL goes here

               String urll = buffer.toString().split("https://once.deputy.com/my/accept-invite?key")[0]
           .split("href=")[1];*/
                
                //Hardcoding the URL  
                
                        String urll = "https://once.deputy.com/my/accept-invite?key=c6eac2e1527558d6904d34b8bae3f207dc11e405";
                System.out.println("URL: "+urll);
                return urll;
                                           
            }
    }
}        