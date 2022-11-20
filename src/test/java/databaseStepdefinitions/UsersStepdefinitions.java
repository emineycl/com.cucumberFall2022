package databaseStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.*;

public class UsersStepdefinitions {

    /*
    Bir database'e baglanmak ve o database'de ki tablolarda islem yapabilmek icin oncelikle
    sistem yonetivisi ile gorusup  gerekli bilgileri almalisiniz

    Domain ve IP : sql748.main-hosting.eu ya da 82.180.174.52
    Port : 3306
    Veritabanı : u480337000_jdbc_data
    Kullanıcı Adı : u480337000_jdbc_user
    Parola : 4Ob8Y]DJU/f

    Tablo : users
    Users Tablosu Alanlar : id,first_name,last_name,email,gender,birth_date,ip_address,
                           is_customer,customer_number,status
    database turu : mySql

    1- ilk adim olarak database turune uygun JDBC dependency'sini pom'a eklemeliyiz
    2- Database turune uygun olarak , username ve password hazirlayin
    3- database baglantisi, query calistirma ve dönen sonucu kaydetmek icin veriable'lar olusturun
    4- tets adimlarina uygun ilerleyebilirsiniz

     */
    String url="jdbc:mysql://sql748.main-hosting.eu:3306/u480337000_jdbc_data";
    String username="u480337000_jdbc_user";
    String password="4Ob8Y]DJU/f";

    Connection connection; //database'e baglantimizi saglayacak
    Statement statement;  // database'de istedigimiz query'leri calistirmamizi saglar
    ResultSet resultSet;  // statement ile yapilan sorgu sonucunu store etmek icin kullanilir


    @Given("Kullanici JDBS ile database'e baglanir")
    public void kullanici_jdbs_ile_database_e_baglanir() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    @Then("users tablosundaki isim verilerini alir")
    public void users_tablosundaki_isim_verilerini_alir() throws SQLException {
        //connection ilk adimda kuruldu
        //query'leri calistiracagimiz statement objeside ilk adimda olusturuldu
        //simdi once string olarak sorguyu hazirlayip
        //sonra statement objesini kullanarak query calistiracagiz
        //ve donen sonucu resultSet objesine store edecegiz

        String query="SELECT first_name FROM users";
        resultSet=statement.executeQuery(query);
    }
    @Then("isim verilerini test eder")
    public void isim_verilerini_test_eder() throws SQLException {

        //ilk iki adimda gerekli java sql objelerini olusturduk
        //connection ile baglantiyi sagladik
        //statement'a connection uzerinden sorgu yapma ozellikleirni yukledik
        //statement objesini kullanarak istedigimiz database sorgusunu calistirip
        //sonuclari resultSet objesine store ettik
        //yani suan da elimizde 1000 adet isim barindiran bir resultSet objesi var
        //bu objeyi kullanarak istedigimiz isim bilgilerine ulasabilir
        //ve istenen testleri yapabiliriz

        //ilk ismi yazdiralim
        //resultSet iterator ile calisir

        resultSet.first();
        System.out.println(resultSet.getString("first_name"));  //Laraine

        //ikinci ve ucuncu isimleri yazdiralim
        resultSet.next();
        System.out.println(resultSet.getString("first_name"));  //Kassi
        resultSet.next();
        System.out.println(resultSet.getString("first_name"));    //Kleon

        //11. satirdaki ismin trever oldugunu test edelim
        resultSet.absolute(11);
        String actual11nciIsim=resultSet.getString("first_name");
        String expected11nci="Trever";
        Assert.assertEquals(expected11nci,actual11nciIsim);


        //son ismin Jaime oldugunu test edin
        resultSet.last();
        String actualSonIsim=resultSet.getString("first_name");
        String expectedSonIsim="Jaime";
        Assert.assertEquals(expectedSonIsim,actualSonIsim);

        //tum isim listesini yazdirin
        System.out.println("==========");

        resultSet.absolute(0);
        int siraNo=1;

        while (resultSet.next()) {
            System.out.println(resultSet.getString(siraNo + "-"+resultSet.getString( "first_name")));
            siraNo++;
        }



    }
}
