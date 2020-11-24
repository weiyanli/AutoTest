import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class MainTest{

    private  String name="干树叶";
    private  String nickName="dryleaves";
    private String mobile="15212312312";
    private ContactPage contactPage;
    private SearchPage searchPage;
    private MembInfoPage membInfoPage;
    private AddMenuPage addMenuPage;

    @BeforeClass
    public void setUp()  {
        contactPage=new ContactPage();
    }

    @Test(priority = 1)
    public void addMembers() {
        //进入添加成员页
        addMenuPage=contactPage.goToAddPage();
        addMenuPage.addAsManu().addMember(name,mobile,"女");
        addMenuPage.back();

        //搜索界面 验证添加成功
        searchPage=contactPage.gotoSearch();
        assert searchPage.vertifyHaveName(name).isDisplayed();
        contactPage.back();
    }

    @Test(priority = 2)
    public void updateMembers() {
        //搜索并进入个人信息页
        membInfoPage=contactPage.gotoSearch().searchAndClick(name);
        membInfoPage.gotoEditMember().updateMember(nickName,"男");
        //验证修改
        assert membInfoPage.getNickName().equals(nickName);
    }
    @Test(priority = 3)
    public void deleteMembers() {
        //进入编辑成员页
        membInfoPage.gotoEditMember().deleteMember();
        //验证删除成功
        assert searchPage.getSearchResults().equals("无搜索结果");
    }



}
