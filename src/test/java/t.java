import com.example.logistics_system.dao.ICustomerDao;
import com.example.logistics_system.pojo.CustomerDto;
import com.example.logistics_system.service.ICustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author:沈玲彬
 * @create: 2022-10-17 20:25
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class t {
    @Autowired
    private ICustomerDao customerDao;
    @Autowired
    private ICustomerService customerService;
    @Test
    public void name() {
        CustomerDto libai = customerService.personal("libai55");
        System.out.println(libai);
    }
}
