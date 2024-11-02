package com.etiya.customerservice.dto.CustomerAccount.request;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.DefaultValue;
import lombok.*;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerAccountRequestDto {
    @NotNull
    private Integer customerId;
    private List<Integer> addressIds;
    private Integer typeId;

}
