import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.DelselectPage;
import page.MainPage;
import page.SearchPage;
import page.SelectPage;


public class SelectTest {
    static MainPage mainPage;
    static SearchPage searchPage;
    static SelectPage selectPage;
    static DelselectPage delselectPage;

    @BeforeAll
    static void beforeAll(){
        mainPage=MainPage.start();
//        searchPage=mainPage.gotoSearch();
        selectPage=mainPage.gotoSelect();
    }


    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "alibaba, 阿里巴巴",
            "sogo, 搜狗"
    })
    void 添加自选测试(String keyword,String name){
        if(selectPage.getstockAll().contains(name)){
            System.out.println("已经添加自选");
        }
        else{
            selectPage.Search();
            selectPage.addSelect(keyword,name);
        }
    }
    @ParameterizedTest
    @CsvSource({
            "拼多多",
            "阿里巴巴",
            "搜狗"
    })
    void 删除自选测试(String name) {
        if (!selectPage.getstockAll().contains(name)) {
            System.out.println("删除自选股票未添加自选");

        }
        else{
            delselectPage=selectPage.gotoDelselectPage(name);
            delselectPage.Delselect();
        }
    }
}
