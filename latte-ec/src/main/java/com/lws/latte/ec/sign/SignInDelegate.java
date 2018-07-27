package com.lws.latte.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joanzapata.iconify.widget.IconTextView;
import com.lws.latte.delegates.LatteDelegate;
import com.lws.latte.ec.R;
import com.lws.latte.ec.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SignInDelegate extends LatteDelegate {
    @BindView(R2.id.et_sign_in_email)
    TextInputEditText mEtEmail;
    @BindView(R2.id.et_sign_in_password)
    TextInputEditText mEtPassword;
    @BindView(R2.id.btn_sign_in)
    AppCompatButton mBtnSignIn;
    @BindView(R2.id.tv_link_sign_up)
    AppCompatTextView mTvLinkSignUp;
    @BindView(R2.id.icon_sign_in_we_chat)
    IconTextView mIconWeChat;

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {

        }
    }

    @OnClick(R2.id.icon_sign_in_we_chat)
    void onClickWeChat() {

    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLinkSignUp() {
        start(new SignUpDelegate());
    }

    private boolean checkForm() {
        String email = mEtEmail.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();

        boolean isPass = true;
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEtEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEtEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mEtPassword.setError("请填写至少六位数密码");
            isPass = false;
        } else {
            mEtPassword.setError(null);
        }
        return isPass;
    }
}
