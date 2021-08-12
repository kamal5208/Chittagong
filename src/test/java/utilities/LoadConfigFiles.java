package utilities;



import automation_test.CalculateMonthlyPayment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfigFiles {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMonthlyPayment.class);
    public Properties readPropertyValues() throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = null;
        try{
            String propertyFileName="config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
            if(inputStream!= null){
                prop.load(inputStream);
            }else {
                throw new FileNotFoundException("Property File " + propertyFileName + "not found in the classpath");
            }
    }catch (Exception e){
            LOGGER.error("Exception is:" +e.getMessage());

        } finally {
            inputStream.close();

        }
        return prop;
        }
}
