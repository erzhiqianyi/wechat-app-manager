package com.erzhiqian.wechatappmanager.specification

import com.erzhiqian.wechatappmanager.BasicSpecification
import com.erzhiqian.wechatappmanager.application.dto.NewWechatApp

import static org.springframework.http.HttpStatus.CREATED

class WechatSpecification extends BasicSpecification {

    def "should add new wechat app"() {
        given:
        def newWechatApp = new NewWechatApp();
        when:
        def response = post('/apps/gh_82bdb360393c', newWechatApp)

        then:
        response.statusCode == CREATED
    }
}
