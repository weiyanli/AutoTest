

import org.junit.Before;
import org.junit.jupiter.api.*;
import pages.*;

import java.net.MalformedURLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTest{

    private  String name="干树叶";
    private  String nickName="dryleaves";
    private String mobile="15212312312";
    private static ContactPage contactPage;
    private SearchPage searchPage;
    private MembInfoPage membInfoPage;
    private AddMenuPage addMenuPage;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        contactPage=new ContactPage();
    }

    @Test
    @Order(1)
    public void addMembers() {
        //进入添加成员页
        addMenuPage=contactPage.goToAddPage();
        addMenuPage.addAsManu().addMember(name,mobile,"女");
        addMenuPage.back();

        //搜索界面 验证添加成功
        searchPage=contactPage.gotoSearch();
        assert searchPage.vertifyHaveName(name).isDisplayed();

    }

    @Test
    @Order(2)
    public void updateMembers() {
        //搜索并进入个人信息页
        membInfoPage=contactPage.gotoSearch().searchAndClick(name);
        membInfoPage.gotoEditMember().updateMember(nickName,"男");
        //验证修改
        assert membInfoPage.getNickName().equals(nickName);
    }
    @Test
    @Order(3)
    public void deleteMembers() {
        //进入编辑成员页
        searchPage=contactPage.gotoSearch();
        searchPage.searchAndClick(name).gotoEditMember().deleteMember();
        //验证删除成功
        assert searchPage.getSearchResults().equals("无搜索结果");
    }

    @AfterEach
    public void back(){
        contactPage.back();
    }



}
