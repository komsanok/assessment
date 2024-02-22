package com.kbtg.bootcamp.posttest;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("ระบบย่อยซื้อลอตเตอรี่")
                        .description("แอพพลิเคชั่นธนาคารต้องการเพิ่มฟีเจอร์ให้ผู้ใช้งานสามารถซื้อลอตเตอรี่ได้ เพื่อตอบสนองกลุ่มนักเสี่ยงโชคยุคใหม่ที่ต้องการความสะดวก และไม่ต้องกังวลเรื่องการจัดเก็บลอตเตอรี่ไว้กับตัวเอง รวมทั้งการขึ้นเงินก็สามารถทำผ่านแอพพลิเคชั่นได้อย่างง่ายดาย")
                        .version("1.0"));
    }
}