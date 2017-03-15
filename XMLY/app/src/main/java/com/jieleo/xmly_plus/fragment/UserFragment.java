package com.jieleo.xmly_plus.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.activity.LoginActivity;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class UserFragment extends BaseFragment implements View.OnClickListener {
    private ImageView headIv,scanIv,toOtherIv;
    private RelativeLayout recordRl,liveRl;
    private TextView userNameTv,introduceTv,historyTv,rssTv,downloadTv,msgTv,buyTv,walletTv,spreadTv,likeTv,freeFluxTv,moreTv,callBackTv,settingTv;
    @Override
    protected int bindLayout() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        headIv = (ImageView) view.findViewById(R.id.iv_head_fragment_user);
        scanIv = (ImageView) view.findViewById(R.id.iv_scan_fragment_user);
        toOtherIv = (ImageView) view.findViewById(R.id.iv_to_other_fragment_user);
        recordRl = (RelativeLayout) view.findViewById(R.id.rl_record_fragment_user);
        liveRl = (RelativeLayout) view.findViewById(R.id.rl_main_live_fragment_user);
        userNameTv = (TextView) view.findViewById(R.id.tv_user_name_fragment_user);
        introduceTv = (TextView) view.findViewById(R.id.tv_introduce_fragment_user);
        historyTv = (TextView) view.findViewById(R.id.tv_history_fragment_user);
        rssTv = (TextView) view.findViewById(R.id.tv_rss_fragment_user);
        downloadTv = (TextView) view.findViewById(R.id.tv_download_fragment_user);
        msgTv = (TextView) view.findViewById(R.id.tv_msg_fragment_user);
        buyTv = (TextView) view.findViewById(R.id.tv_my_buy_fragment_user);
        walletTv = (TextView) view.findViewById(R.id.tv_my_wallet_fragment_user);
        spreadTv = (TextView) view.findViewById(R.id.tv_spread_fragment_user);
        likeTv = (TextView) view.findViewById(R.id.tv_i_liked_fragment_user);
        freeFluxTv = (TextView) view.findViewById(R.id.tv_free_flux_fragment_user);
        moreTv = (TextView) view.findViewById(R.id.tv_more_fragment_user);
        callBackTv = (TextView) view.findViewById(R.id.tv_callback_fragment_user);
        settingTv = (TextView) view.findViewById(R.id.tv_setting_fragment_user);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {
        headIv.setOnClickListener(this);
        scanIv.setOnClickListener(this);
        toOtherIv.setOnClickListener(this);
        recordRl.setOnClickListener(this);
        liveRl.setOnClickListener(this);
        userNameTv.setOnClickListener(this);
        introduceTv.setOnClickListener(this);
        historyTv.setOnClickListener(this);
        rssTv.setOnClickListener(this);
        downloadTv.setOnClickListener(this);
        msgTv.setOnClickListener(this);
        buyTv.setOnClickListener(this);
        walletTv.setOnClickListener(this);
        spreadTv.setOnClickListener(this);
        likeTv.setOnClickListener(this);
        freeFluxTv.setOnClickListener(this);
        moreTv.setOnClickListener(this);
        callBackTv.setOnClickListener(this);
        settingTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_head_fragment_user:
                //头像的点击事件
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_scan_fragment_user:
                //扫描二维码的点击事件
                break;
            case R.id.iv_to_other_fragment_user:
                //点击更多
                break;
            case R.id.rl_record_fragment_user:
                //录音的点击事件
                break;
            case R.id.rl_main_live_fragment_user:
                //主播中心的点击事件
                break;
            case R.id.tv_user_name_fragment_user:
                //用户名
                break;
            case R.id.tv_introduce_fragment_user:
                //用户介绍
                break;
            case R.id.tv_history_fragment_user:
                //历史的点击事件
                break;
            case R.id.tv_rss_fragment_user:
                //订阅的点击事件
                break;
            case R.id.tv_download_fragment_user:
                //下载的点击事件
                break;
            case R.id.tv_msg_fragment_user:
                //我的消息的点击事件
                break;
            case R.id.tv_my_buy_fragment_user:
                //我的已购的点击事件
                break;
            case R.id.tv_my_wallet_fragment_user:
                //我的钱包的点击事件
                break;
            case R.id.tv_spread_fragment_user:
                //分享赚钱的点击事件
                break;
            case R.id.tv_i_liked_fragment_user:
                //我喜欢的点击事件
                break;
            case R.id.tv_free_flux_fragment_user:
                //免流量服务的点击事件
                break;
            case R.id.tv_more_fragment_user:
                //更多的点击事件
                break;
            case R.id.tv_callback_fragment_user:
                //意见反馈的点击事件
                break;
            case R.id.tv_setting_fragment_user:
                //设置的点击事件
                break;
        }
    }
}
