package com.jieleo.xmly_plus.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;
import com.jieleo.xmly_plus.MyApp;
import com.jieleo.xmly_plus.R;
import com.jieleo.xmly_plus.activity.LoginActivity;

import com.jieleo.xmly_plus.activity.WebActivity;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


/**
 * Created by yuyongjie on 17/3/9.
 */


public class UserFragment extends BaseFragment implements View.OnClickListener {
    private ImageView headIv, scanIv, toOtherIv, createQRIv;
    private RelativeLayout recordRl, liveRl;
    private TextView userNameTv, introduceTv, historyTv, rssTv, downloadTv, msgTv, buyTv, walletTv, spreadTv, likeTv, freeFluxTv, moreTv, callBackTv, settingTv;
    private RecognizerDialog mDialog;

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
        createQRIv = (ImageView) view.findViewById(R.id.iv_qr_fragment_user);
    }

    @Override
    protected void initData() {

        mDialog = new RecognizerDialog(getActivity(), new InitListener() {
            @Override
            public void onInit(int i) {
                Log.d("UserFragment", "i:" + i);
            }
        });
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
                final Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_scan_fragment_user:
                //扫描二维码的点击事件
                Intent openCamera = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(openCamera, 0);


                break;
            case R.id.iv_to_other_fragment_user:
                //点击更多
                final Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.rl_record_fragment_user:
                //录音的点击事件
                break;
            case R.id.rl_main_live_fragment_user:
                mDialog.setParameter(SpeechConstant.DOMAIN, "iat");
                mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
                mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");
                mDialog.setListener(new RecognizerDialogListener() {
                    @Override
                    public void onResult(RecognizerResult recognizerResult, boolean b) {
                        Log.d("UserFragment", "b:" + b);
                        Log.d("haha", parseIatResult(recognizerResult.getResultString()));
                        String words = parseIatResult(recognizerResult.getResultString()).replace(" ", "");
                        if (words.length()>=2){
                        String URL_PART_ONE = "https://www.baidu.com/s?wd=";
                        String URL_PART_TWO = "&rsv_spt=1&rsv_iqid=0xd973ffd5000c2260&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=5&rsv_sug1=3&rsv_sug7=100&rsv_t=21fd9Sc%2F726XvIzvOJk3ol%2FE2OhqJXusxWjpCh29zvKjK1Oj7TB7q4cMOQLRSZmXmHky&rsv_sug2=0&inputT=978&rsv_sug4=1542&rsv_sug=1";
                        String url=URL_PART_ONE+words+URL_PART_TWO;
                        Intent intent2=new Intent(getActivity(),WebActivity.class);
                        intent2.putExtra("url",url);
                        startActivity(intent2);
                        }


                    }

                    @Override
                    public void onError(SpeechError speechError) {

                    }
                });
                mDialog.show();
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
                String string = "https://wx.tenpay.com/f2f?t=AQAAAFpkOSeE8bc%2FsY2B%2BFFZuts%3D";
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 3;
                Bitmap bitmap = EncodingUtils.createQRCode(string, 500, 500, BitmapFactory.decodeResource(getResources(), R.mipmap.imgsishuai_1, options));
                createQRIv.setImageBitmap(bitmap);
                break;
            case R.id.tv_callback_fragment_user:
                //意见反馈的点击事件
                break;
            case R.id.tv_setting_fragment_user:
                //设置的点击事件
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            Intent intent = new Intent(getActivity(), WebActivity.class);
            intent.putExtra("url", scanResult);
            startActivity(intent);
        }
    }


    public static String parseIatResult(String json) {
        StringBuffer ret = new StringBuffer();
        try {
            JSONTokener tokener = new JSONTokener(json);
            JSONObject joResult = new JSONObject(tokener);
            JSONArray words = joResult.getJSONArray("ws");
            for (int i = 0; i < words.length(); i++) {
                //转写结果词，默认使用第一个结果
                JSONArray items = words.getJSONObject(i).getJSONArray("cw");
                JSONObject obj = items.getJSONObject(0);
                ret.append(obj.getString("w"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret.toString();
    }
}
