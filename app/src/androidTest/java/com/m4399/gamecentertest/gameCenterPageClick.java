package com.m4399.gamecentertest;

import android.graphics.Point;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import javax.crypto.spec.DESedeKeySpec;

public class gameCenterPageClick extends autoTestBase{
    //resourceID配置

    //非插件版本：com.m4399.gamecenter
    //主插件版本：com.m4399.gamecenter.plugin.main
    public String index = "com.m4399.gamecenter";
    @Before
    public void setUp(){

    }
    @Test
    public void homePage() throws IOException, InterruptedException {
        restartApp();
        errorHandleAdd("perssionAllow","com.m4399.gamecenter:id/btn_dialog_horizontal_left");
        UiObject2 gameSearch = device.findObject(By.res(index+RL_GAME_SEARCH));
        gameSearch.click();
        device.wait(Until.findObject(By.res(index+IB_QR_SCAN)),5000);
        device.findObject(By.res(index+IB_DO_SEARCH)).click();
        device.wait(Until.findObject(By.res(index+TV_TAB_TITLE)),5000);
        device.pressBack();
    }
    //二维码扫描遍历
    @Test
    public void urCode() throws InterruptedException, IOException {
        restartApp();
        device.findObject(By.res(index+RL_GAME_SEARCH)).click();
        device.wait(Until.findObject(By.res(index+IB_QR_SCAN)),5000);
        device.findObject(By.res(index+IB_QR_SCAN)).click();
        device.wait(Until.findObject(By.res(index+IV_ALBUM)),5000);
        device.findObject(By.res(index+IV_ALBUM)).click();
        device.wait(Until.findObject(By.res(index+PICTURE_CHECK)),5000);
        device.findObject(By.res(index+PICTURE_CHECK)).click();
        device.findObject(By.res(index+CONFIRN_BTN)).click();
        Thread.sleep(5000);
        boolean a = new Boolean(device.hasObject(By.res(index+TV_NAME)));
        if (a == true){
            device.pressBack();
        }
        device.wait(Until.findObject(By.res(index+IV_LIGHT)),5000);
        device.findObject(By.res(index+IV_LIGHT)).click();
        Thread.sleep(2000);
        device.findObject(By.res(index+IV_LIGHT)).click();
        device.findObject(By.res(index+TV_MY_QRCODE)).click();
        device.wait(Until.findObject(By.res(index+USERQRIMAGEVIEW)),5000);
        device.findObject(By.res(index+M4399_MENU_SAVE)).click();
        Thread.sleep(2000);
        device.pressBack();
        device.pressBack();

    }
    //插件下载安装
    @Test
    public void pluginInstall() throws IOException, InterruptedException, UiObjectNotFoundException {
        restartApp();
        device.findObject(By.res(index+TV_TAB_TITLE).text("直播")).click();
        device.wait(Until.findObject(By.res(index+LIVE_TITLE_NAME)),10000);
        device.findObject(By.res(index+TV_TAG_NAME).text("全部直播")).click();
        device.wait(Until.findObject(By.res(index+IV_OPEN_LIVE_ALL_CATEGORY)),10000);
        device.findObject(By.res(index+IV_LIVE_PICTURE)).click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter.plugin.livetv:id/ibtn_gift")),10000);
        device.pressBack();
        restartApp();
        tabClickMy();
        device.wait(Until.findObject(By.res(index+TV_HEBI_RECHARGE)),1000);
        device.findObject(By.res(index+TV_HEBI_RECHARGE)).click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter.plugin.recharge:id/m4399_gdui_billing_btn_text")),10000);
        device.pressBack();
        restartApp();
        tabClickMy();
        Thread.sleep(2000);
        device.wait(Until.findObject(By.res(index+TV_MENU_NAME).text("赚零花钱")),10000);
        device.findObject(By.res(index+TV_MENU_NAME).text("赚零花钱")).click();
        device.wait(Until.findObject(By.res(index+MAKE_MONEY_LIST_CELL_TITLE)),10000);
        device.findObject(By.res(index+MAKE_MONEY_LIST_CELL_TITLE).text("试玩单机游戏赚盒币")).click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter.plugin.jfq:id/txt_appName")),10000);
        device.pressBack();
    }
    //游戏下载
    @Test
    public void rechargePluginInstall() throws UiObjectNotFoundException {
        scrollIntoObject("android.support.v7.widget.RecyclerView",index+END_LOGO);
    }

    @Test
    public void zomeVideosPublish() throws IOException, InterruptedException, UiObjectNotFoundException {
//        restartApp();
//        device.findObject(new UiSelector().resourceId(index+IV_TAB_ICON).instance(1)).click();
//        device.wait(Until.findObject(By.res(index+IV_MENU_ITEM_PUBLISH)),5000);
//        UiObject2 zonePublish = device.findObject(By.res(index+IV_MENU_ITEM_PUBLISH));
//        Point x = zonePublish.getVisibleCenter();
//        int a = x.x;
//        int b = x.y;
//        device.swipe(a,b,a+10,b+10,100);
        device.wait(Until.findObject(By.res(index + BUTTON_RECORD)), 5000);
        UiObject2 buttonRecord = device.findObject(By.res(index + BUTTON_RECORD));
        Point y = buttonRecord.getVisibleCenter();
        int c = y.x;
        int d = y.y;
        device.swipe(c, d, c + 10, d + 10, 500);
        device.findObject(By.res(index + BUTTON_NEXT)).click();
        device.wait(Until.findObject(By.res(index + VIDEO_PREVIEW_COMMIT_IV)), 5000);
        device.findObject(By.res(index + VIDEO_PREVIEW_COMMIT_IV)).click();
        device.wait(Until.findObject(By.res(index + M4399_TOPIC_PUBLISH)), 5000);
        UiObject2 zoneEdit = device.findObject(By.res(index + ZONE_EDIT));

        buttonRecord.setText("自动化测试");
    }
    @Test
    public void videoslide() throws InterruptedException {
        for (int i = 1;i<50;i++){
            device.swipe(1090,2000,1090,600,20);
            Thread.sleep(6000);
        }

    }
    //添加自定义表情200张
    @Test
    public void customizePicture() throws  IOException, InterruptedException {
        restartApp();
        tabClickMy();
        device.findObject(By.res("com.m4399.gamecenter:id/btn_shop")).click();
        device.wait(Until.findObject(By.desc("更多选项")),10000);
        device.findObject(By.desc("更多选项")).click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/title").text("我的表情")),10000);
        device.findObject(By.res("com.m4399.gamecenter:id/title").text("我的表情")).click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/tv_tab_title").text("自定义表情")),10000);
        device.findObject(By.res("com.m4399.gamecenter:id/tv_tab_title").text("自定义表情")).click();
        UiObject2 picEidtButton = device.findObject(By.res("com.m4399.gamecenter:id/m4399_menu_message_edit"));
        boolean picEdit = picEidtButton.isEnabled();
        if (picEdit == true){
            device.findObject(By.res("com.m4399.gamecenter:id/m4399_menu_message_edit")).click();
            device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/message_control_checkbox")),10000);
            device.findObject(By.res("com.m4399.gamecenter:id/message_control_checkbox")).click();
            device.findObject(By.res("com.m4399.gamecenter:id/messageDeleteButton")).click();
            Thread.sleep(5000);
        }
        for (int i = 0; i < 200; i++) {
            UiObject2 addButtom = device.findObject(By.res("com.m4399.gamecenter:id/iv_icon"));
            addButtom.click();
            device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/pic_check")), 10000);
            device.findObject(By.res("com.m4399.gamecenter:id/pic_check")).click();
            UiObject2 confirm = device.findObject(By.res("com.m4399.gamecenter:id/confirm_btn"));
            confirm.clickAndWait(Until.newWindow(),10000);
            device.wait(Until.gone(By.res("com.m4399.gamecenter:id/mLoadingText")),10000);
        }
    }
    @Test
    public void sendZone() throws IOException, InterruptedException {
        restartApp();
        tabClickZone();
        UiObject2 aobject = device.findObject(By.res("clickAndWait()"));
        device.findObject(By.res("com.m4399.gamecenter:id/iv_menu_item_publish")).click();
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/m4399_topic_publish")),10000);

    }
    //发送动态
    @Test
    public void zoneSend() throws IOException, InterruptedException {
        errorHandleAdd("perssionCheck","android:id/button1");//注册监听器
        restartApp();//重启APP
        tabClickZone();//点击动态模块
        String zoneRandom = getRandomString(5);//增加随机字符串
        device.findObject(By.res("com.m4399.gamecenter:id/iv_menu_item_publish")).clickAndWait(Until.newWindow(),10000);//点击发动态按钮并等待新窗口出现
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/zone_edit")),10000);//等待找到动态编辑窗口进行下一步
        device.findObject(By.res("com.m4399.gamecenter:id/zone_edit")).setText("今天天气真不错呢"+zoneRandom);//输入文本内容"今天天气真不错呢"+随机字符，防止发重复动态
        device.findObject(By.res("com.m4399.gamecenter:id/add_image")).clickAndWait(Until.newWindow(),10000);//点击添加图片按钮并等待新窗口出现
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/camera_btn")),10000);//等待找到拍照按钮
        device.findObject(By.res("com.m4399.gamecenter:id/camera_btn")).clickAndWait(Until.newWindow(),10000);//点击拍照按钮
        device.wait(Until.findObject(By.res("com.android.camera:id/v9_shutter_button_internal")),1000);//等待出现相机快门按钮
        device.findObject(By.res("com.android.camera:id/v9_shutter_button_internal")).click();//点击相机快门按钮
        device.wait(Until.findObject(By.res("com.android.camera:id/inten_done_apply")),10000);//等待找到√按钮
        device.findObject(By.res("com.android.camera:id/inten_done_apply")).clickAndWait(Until.newWindow(),10000);//点击√按钮
        device.findObject(By.res("com.m4399.gamecenter:id/m4399_topic_publish")).click();//点击发布按钮
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/zone_del_btn")),10000);//点击发布后等待页面出现动态删除按钮，即返回到动态列表页面
        if (device.hasObject(By.res("com.m4399.gamecenter:id/tv_send_fail_notice").text("发送中"))){
            device.wait(Until.gone(By.res("com.m4399.gamecenter:id/tv_send_fail_notice").text("发送中")),10000);
        }//在动态tab上判断，如果有发布中状态，则等待发布中状态消失后进行下一步
        tabClickMy();//点击我tab
        device.findObject(By.res("com.m4399.gamecenter:id/uiv_circle_view")).clickAndWait(Until.newWindow(),10000);//点击头像进入个人主页
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/tv_tab_title")),10000);//等待加载个人主页出现tab数据
        device.findObject(By.res("com.m4399.gamecenter:id/tv_tab_title").text("动态")).click();//点击动态tab切换到动态tab
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/zone_feel")),10000);//等待加载出动态列表
        Assert.assertTrue("zoneSendSuccess",device.hasObject(By.res("com.m4399.gamecenter:id/zone_feel").text("今天天气真不错呢"+zoneRandom)));//断言刚才发布的动态是否存在列表中
    }
    @Test
    public void textdemo(){
        device.findObject(By.res("com.m4399.gamecenter:id/tv_tab_title").text("帖子")).click();
    }
    @After
    public void tearDown(){

    }
}
