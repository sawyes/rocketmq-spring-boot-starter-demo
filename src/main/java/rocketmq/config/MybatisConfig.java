package rocketmq.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"rocketmq.dao"})
public class MybatisConfig {
}
