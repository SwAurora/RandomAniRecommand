package com.sw.randomanirecommand.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberForm
{
    @NotEmpty(message = "아이디를 입력해야합니다.")
    @Length(min = 6, max = 16, message = "아이디는 6 ~ 16자 이내여야 합니다.")
    private String uid;

    @NotEmpty(message = "비밀번호를 입력해야합니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String upw;

    @NotBlank(message = "닉네임을 입력해야 합니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,12}$", message = "닉네임은 특수문자를 제외한 2 ~ 12자리 이내여야 합니다.")
    private String nickName;
}
