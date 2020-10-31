package com.erzhiqian.wechatappmanager.specification

import com.erzhiqian.wechatappmanager.BasicSpecification
import com.erzhiqian.wechatappmanager.application.dto.NewAppSecret
import com.erzhiqian.wechatappmanager.application.dto.NewAuthorizerInfo
import com.erzhiqian.wechatappmanager.application.dto.NewDevProfile
import com.erzhiqian.wechatappmanager.application.dto.NewWechatApp

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

class WechatSpecification extends BasicSpecification {
    def tenantId = "gh_82bdb360393c"

    protected NewAppSecret createAppSecret(String appSecret) {
        def newAppSecret = new NewAppSecret(appSecret: appSecret)
        return newAppSecret;
    }

    protected NewAuthorizerInfo createNewAuthorizerInfo(
            String nickName, String headImage, String username,
            String principalName, String appType, String certifiedState) {
        def newAuthorizerInfo = new NewAuthorizerInfo(nickname: nickName, headImage: headImage,
                username: username, principalName: principalName,
                appType: appType, certifiedState: certifiedState)
        return newAuthorizerInfo;

    }

    protected NewDevProfile createNewDevProfile(String token, String encodingAESKey,
                                                String dataSignType, String dataContentType) {
        def newDevProfile = new NewDevProfile(token: token, encodingAESKey: encodingAESKey,
                dataSignType: dataSignType, dataContentType: dataContentType);
        return newDevProfile;
    }

    def "should add wechat app "() {
        given:
        def newAppSecret = createAppSecret('3d9226db5fc21c3574ab454975de8e20')
        def nickName = "test"
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def username = "gh_852ad136c363"
        def principalName = "erzhiqianyi";
        def newAuthorizerInfo = createNewAuthorizerInfo(nickName, headImage, username, principalName, appType, certifiedState);
        def token = "04MzOmzVA48Q0MLHGYsD3BdD6UBbGruZ"
        def encodingAESKey = "m6qD0p1CUkQ83CMvJRMRY6V8vTAK63EZkglCsARucYJ"
        def newDevProfile = createNewDevProfile(token, encodingAESKey, dataSignType, dataContentType)
        def appId = "wx4ff4f9c7af819999"
        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: newAppSecret, devProfile: newDevProfile);
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == CREATED
        where:
        appType        | certifiedState | dataSignType    | dataContentType
        'SUBSCRIBE'    | 'CERTIFIED'    | 'SAFE'          | 'JSON'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'SAFE'          | 'XML'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'UN_SAFE'       | 'JSON'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'UN_SAFE'       | 'XML'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'COMPATIBILITY' | 'JSON'
        'SUBSCRIBE'    | 'CERTIFIED'    | 'COMPATIBILITY' | 'XML'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'SAFE'          | 'JSON'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'SAFE'          | 'XML'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'UN_SAFE'       | 'JSON'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'UN_SAFE'       | 'XML'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'JSON'
        'SUBSCRIBE'    | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'XML'
        'SERVICES'     | 'CERTIFIED'    | 'SAFE'          | 'JSON'
        'SERVICES'     | 'CERTIFIED'    | 'SAFE'          | 'XML'
        'SERVICES'     | 'CERTIFIED'    | 'UN_SAFE'       | 'JSON'
        'SERVICES'     | 'CERTIFIED'    | 'UN_SAFE'       | 'XML'
        'SERVICES'     | 'CERTIFIED'    | 'COMPATIBILITY' | 'JSON'
        'SERVICES'     | 'CERTIFIED'    | 'COMPATIBILITY' | 'XML'
        'SERVICES'     | 'UN_CERTIFIED' | 'SAFE'          | 'JSON'
        'SERVICES'     | 'UN_CERTIFIED' | 'SAFE'          | 'XML'
        'SERVICES'     | 'UN_CERTIFIED' | 'UN_SAFE'       | 'JSON'
        'SERVICES'     | 'UN_CERTIFIED' | 'UN_SAFE'       | 'XML'
        'SERVICES'     | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'JSON'
        'SERVICES'     | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'XML'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'SAFE'          | 'JSON'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'SAFE'          | 'XML'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'UN_SAFE'       | 'JSON'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'UN_SAFE'       | 'XML'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'COMPATIBILITY' | 'JSON'
        'MINI_PROGRAM' | 'CERTIFIED'    | 'COMPATIBILITY' | 'XML'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'SAFE'          | 'JSON'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'SAFE'          | 'XML'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'UN_SAFE'       | 'JSON'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'UN_SAFE'       | 'XML'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'JSON'
        'MINI_PROGRAM' | 'UN_CERTIFIED' | 'COMPATIBILITY' | 'XML'


    }

    def "should not add no appid wechat app  "() {
        given:
        def newAppSecret = createAppSecret('3d9226db5fc21c3574ab454975de8e20')
        def nickName = "test"
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def username = "gh_852ad136c363"
        def principalName = "erzhiqianyi";
        def appType = "SERVICES"
        def certifiedState = "CERTIFIED"
        def newAuthorizerInfo = createNewAuthorizerInfo(nickName, headImage, username, principalName, appType, certifiedState);

        def token = "04MzOmzVA48Q0MLHGYsD3BdD6UBbGruZ"
        def encodingAESKey = "m6qD0p1CUkQ83CMvJRMRY6V8vTAK63EZkglCsARucYJ"

        def dataContentType = "JSON"
        def dataSignType = "SAFE"
        def newDevProfile = createNewDevProfile(token, encodingAESKey, dataSignType, dataContentType)
        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: newAppSecret, devProfile: newDevProfile);
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.errorCode == 40001

        where:
        appId << [null, '', ' ']

    }


    def "should not add a wechat app  that already exists"() {
        given:
        def tenantId = "gh_82bdb360393c"
        def newAppSecret = createAppSecret(appSecret)
        def newAuthorizerInfo = createNewAuthorizerInfo(nickname, headImage, username, principalName, appId, certifiedState);
        def newDevProfile = createNewDevProfile(token, encodingAESKey, dataSignType, dataSignType)
        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: newAppSecret, devProfile: newDevProfile);
        when:
        post('/apps/' + tenantId, newWechatApp)
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.errorCode == 40002

        where:
        appId                | nickname | username          | principalName | appType    | certifiedState | dataSignType | dataContentType | appSecret                          | token                              | encodingAESKey                                | headImage
        'wx4ff4f9c7af819999' | 'test'   | 'gh_852ad136c363' | 'erzhiqianyi' | 'SERVICES' | 'UN_CERTIFIED' | 'SAFE'       | 'JSON'          | '3d9226db5fc21c3574ab454975de8e20' | '04MzOmzVA48Q0MLHGYsD3BdD6UBbGruZ' | 'm6qD0p1CUkQ83CMvJRMRY6V8vTAK63EZkglCsARucYJ' | 'https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0'
    }

    def "should not add an unnamed  wechat app  "() {
        given:
        def tenantId = "gh_82bdb360393c"
        def appId = "wx4ff4f9c7af819999";
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def appType = "SERVICES"
        def certifiedState = "UN_CERTIFIED"
        def newAuthorizerInfo = createNewAuthorizerInfo(nickname, headImage, username, principalName, appType, certifiedState);
        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: null, devProfile: null);
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.errorCode == errorCode

        where:
        errorCode | nickname | username          | principalName
        40003     | null     | 'gh_852ad136c363' | 'erzhiqianyi'
        40003     | ''       | 'gh_852ad136c363' | 'erzhiqianyi'
        40003     | '  '     | 'gh_852ad136c363' | 'erzhiqianyi'
        40004     | 'test'   | null              | 'erzhiqianyi'
        40004     | 'test'   | ""                | 'erzhiqianyi'
        40004     | 'test'   | " "               | 'erzhiqianyi'
        40005     | 'test'   | 'gh_852ad136c363' | null
        40005     | 'test'   | 'gh_852ad136c363' | ""
        40005     | 'test'   | 'gh_852ad136c363' | "  "
    }

    def "should not add an invalid app type  wechat app  "() {
        given:
        def tenantId = "gh_82bdb360393c"
        def appId = "wx4ff4f9c7af819999";
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def certifiedState = "UN_CERTIFIED"
        def nickName = "test"
        def username = "gh_852ad136c363"
        def principalName = "erzhiqianyi"
        def newAuthorizerInfo = createNewAuthorizerInfo(nickName, headImage, username, principalName, appType, certifiedState);
        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: null, devProfile: null);
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.errorCode == errorCode

        where:
        errorCode | appType
        40006     | null
        40006     | ''
        40006     | ' '
        40007     | 'INVALID_APP_TYPE'
    }

    def "should not add an invalid certified state  wechat app  "() {
        given:
        def tenantId = "gh_82bdb360393c"
        def appId = "wx4ff4f9c7af819999";
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def appType = "SERVICES"
        def nickName = "test"
        def username = "gh_852ad136c363"
        def principalName = "erzhiqianyi"
        def newAuthorizerInfo = createNewAuthorizerInfo(nickName, headImage, username, principalName, appType, certifiedState);
        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: null, devProfile: null);
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.errorCode == errorCode

        where:
        errorCode | certifiedState
        40006     | null
        40006     | ''
        40006     | ' '
        40007     | 'INVALID_APP_TYPE'
    }


    def "should not add an invalid encodingAESKey  wechat app  "() {
        given:
        def tenantId = "gh_82bdb360393c"
        def appId = "wx4ff4f9c7af819999";
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def appType = "SERVICES"
        def nickName = "test"
        def username = "gh_852ad136c363"
        def principalName = "erzhiqianyi"
        def certifiedState = "CERTIFIED"
        def newAuthorizerInfo = createNewAuthorizerInfo(nickName, headImage, username, principalName, appType, certifiedState);
        def token = "04MzOmzVA48Q0MLHGYsD3BdD6UBbGruZ"
        def dataSignType = "SAFE"
        def dataContentType  = "JSON"
        def newDevProfile = createNewDevProfile(token, encodingAESKey, dataSignType, dataContentType)

        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: null, devProfile: newDevProfile)
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.errorCode == errorCode

        where:
        errorCode | encodingAESKey
        40008     | null
        40008     | ''
        40008     | '  '
        40009     | 'djkdfs'
        40009     | 'm6qD0p1CUkQ83CM^JRMRY6V8v&AK63EZkglCsARucYJ'
        40009     | 'm6qD0p号CUkQ83CM^测RMRY6V8v&AK63EZkglCsARucYJ'
        40009     | '219i321328435439583958843jklfjglkdfjgdfkljgkldfjgkldfjgkldfjgklfdjgkldfjgkfdjgkldrfjgkldfjlgkjdflkgjdflk'

    }

   def "should not add an invalid data sign type  or invalid  data content type wechat app  "() {
        given:
        def tenantId = "gh_82bdb360393c"
        def appId = "wx4ff4f9c7af819999";
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def appType = "SERVICES"
        def nickName = "test"
        def username = "gh_852ad136c363"
        def principalName = "erzhiqianyi"
        def certifiedState = "CERTIFIED"
        def newAuthorizerInfo = createNewAuthorizerInfo(nickName, headImage, username, principalName, appType, certifiedState);
        def token = "04MzOmzVA48Q0MLHGYsD3BdD6UBbGruZ"
        def encodingAESKey = "m6qD0p1CUkQ83CMvJRMRY6V8vTAK63EZkglCsARucYJ"
        def newDevProfile = createNewDevProfile(token, encodingAESKey, dataSignType, dataContentType)

        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: null, devProfile: newDevProfile)
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.errorCode == errorCode

        where:
        errorCode | dataSignType | dataContentType
        40010     | null         | 'JSON'
        40010     | ''           | 'JSON'
        40010     | ' '          | 'JSON'
        40011     | 'IN_VALID'   | 'JSON'
        40012     | 'SAFE'       | null
        40012     | 'SAFE'       | ''
        40012     | 'SAFE'       | ' '
        40013     | 'SAFE'       | 'IN_VALID '
    }


    def "should not add an  invalid app secret wechat app  "() {
        given:
        def tenantId = "gh_82bdb360393c"
        def appId = "wx4ff4f9c7af819999";
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def appType = "SERVICES"
        def nickName = "test"
        def username = "gh_852ad136c363"
        def principalName = "erzhiqianyi"
        def certifiedState = "CERTIFIED"
        def newAuthorizerInfo = createNewAuthorizerInfo(nickName, headImage, username, principalName, appType, certifiedState);
        def token = "04MzOmzVA48Q0MLHGYsD3BdD6UBbGruZ"
        def encodingAESKey = "m6qD0p1CUkQ83CMvJRMRY6V8vTAK63EZkglCsARucYJ"
        def dataSignType = "SAFE"
        def dataContentType = "JSON"

        def newDevProfile = createNewDevProfile(token, encodingAESKey, dataSignType, dataContentType)
        def newAppSecret = createAppSecret(appSecret)

        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: newAppSecret, devProfile: newDevProfile)
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.errorCode == errorCode

        where:
        errorCode | appSecret
        40014     | null
        40014     | ''
        40014     | '  '
        40015     | 'fdsklfskdjfdskjfklsdjfklsjfklsdjaflksdjdlkfjkldsjflksjdlfkjlkkkkjlkjlkfjlkjlkjkljlkjlkjkljkljlj'
        40015     | '测试kfdsjkfdjlsjfla'
        40015     | '&*^&*^&&**^^^&*%%%hjkhfkjsdfsd'
    }


    def "should not add an invalid token  wechat app "() {
        given:
        def tenantId = "gh_82bdb360393c"
        def appId = "wx4ff4f9c7af819999";
        def headImage = "https://wx.qlogo.cn/mmhead/Q3auHgzwzM6fHe3NhQBfH4ibsxZk8ktOXRV2Ws7dKDqnlaREKORdHNw/0"
        def appType = "SERVICES"
        def nickName = "test"
        def username = "gh_852ad136c363"
        def principalName = "erzhiqianyi"
        def certifiedState = "CERTIFIED"
        def newAuthorizerInfo = createNewAuthorizerInfo(nickName, headImage, username, principalName, appType, certifiedState);
        def dataSignType = "SAFE"
        def dataContentType  = "JSON"
        def encodingAESKey  = "m6qD0p1CUkQ83CMvJRMRY6V8vTAK63EZkglCsARucYJ"
        def newDevProfile = createNewDevProfile(token, encodingAESKey, dataSignType, dataContentType)

        def newWechatApp = new NewWechatApp(appId: appId, authorizerInfo: newAuthorizerInfo,
                appSecret: null, devProfile: newDevProfile)
        when:
        def response = post('/apps/' + tenantId, newWechatApp)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.errorCode == errorCode

        where:
        errorCode | token
        40016     | null
        40016     | ''
        40016     | ' '
        40017     | '&*&^^反倒赛兰六发动机分开'
        40017     | '234324u32ikfdsjhfksdhfgkjsdhgkdffk,jdjhgkdshgjkdfhgkfjdhsgkhfdsklhlhdf'

    }


}
