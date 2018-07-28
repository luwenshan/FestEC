package com.lws.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.lws.latte.delegates.BaseDelegate;
import com.lws.latte.delegates.LatteDelegate;
import com.lws.latte.ec.R;
import com.lws.latte.ec.R2;
import com.lws.latte.net.RestClient;
import com.lws.latte.net.callback.ISuccess;
import com.lws.latte.util.log.LatteLogger;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpDelegate extends LatteDelegate {


    @BindView(R2.id.et_sign_up_name)
    TextInputEditText mEtName;
    @BindView(R2.id.et_sign_up_email)
    TextInputEditText mEtEmail;
    @BindView(R2.id.et_sign_up_phone)
    TextInputEditText mEtPhone;
    @BindView(R2.id.et_sign_up_password)
    TextInputEditText mEtPassword;
    @BindView(R2.id.et_sign_up_re_password)
    TextInputEditText mEtRePassword;
    @BindView(R2.id.btn_sign_up)
    AppCompatButton mBtnSignUp;
    @BindView(R2.id.tv_link_sign_in)
    AppCompatTextView mTvLinkSignIn;

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @OnClick(R2.id.btn_sign_up)
    public void onClickSignUp() {
        if (checkForm()) {
            RestClient.builder()
                    .url("http://www.wanandroid.com/tools/mockapi/872/sign_up")
//                    .params("name", mEtName.getText().toString())
//                    .params("email", mEtEmail.getText().toString())
//                    .params("phone", mEtPhone.getText().toString())
//                    .params("password", mEtPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE", response);
                            SignHandler.onSignUp(response);
                        }
                    })
                    .build()
                    .get();
            Toast.makeText(getContext(), "验证通过", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLinkSignIn() {
        start(new SignInDelegate());
    }

    private boolean checkForm() {
        String name = mEtName.getText().toString().trim();
        String email = mEtEmail.getText().toString().trim();
        String phone = mEtPhone.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        String rePassword = mEtRePassword.getText().toString().trim();

        boolean isPass = true;
        if (name.isEmpty()) {
            mEtName.setError("请输入姓名");
            isPass = false;
        } else {
            mEtName.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEtEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEtEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() != 11) {
            mEtPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mEtPhone.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mEtPassword.setError("请填写至少六位数密码");
            isPass = false;
        } else {
            mEtPassword.setError(null);
        }

        if (rePassword.isEmpty() || rePassword.length() < 6 || !rePassword.equals(password)) {
            mEtRePassword.setError("密码验证错误");
            isPass = false;
        } else {
            mEtRePassword.setError(null);
        }
        return isPass;
    }
}
