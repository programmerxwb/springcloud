package springcloud.service.impl;

import org.springframework.stereotype.Service;
import springcloud.dao.PayMetDao;
import springcloud.entities.Payment;
import springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PayMetDao payMetDao;

    public int create(Payment payment) {
        return payMetDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return payMetDao.getPaymentById(id);
    }
}
