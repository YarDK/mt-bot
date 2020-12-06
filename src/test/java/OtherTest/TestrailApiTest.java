package OtherTest;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestrailApiTest {

    @Test
    public void testTestrailApi(){
        TestRail testRail = TestRail
                .builder("http://testrail.ru.mgo.su/", "ya.korotyshov@mangotele.com", "Aa795744")
                .applicationName("TestRail MangoQA")
                .build();

        // Проект толкера это id=6
        Project project = testRail.projects().get(6).execute();
        System.out.println("Информация по проекту:\n" + project.toString());
        // Suite(id=6026, name=Автотесты
        // Suite(id=3437, name=VoIP
        // Suite(id=6, name=M.TALKER клиент (мобильный, десктоп, сервер)

        // Сюты
        Suite suite = testRail.suites().get(6026).execute();
        //List<Suite> suite_list = testRail.suites().list(6).execute();
        //suite_list.forEach(System.out::println);
        System.out.println("Информация по сюту:\n" + suite.toString());

        // Секции сюта
        System.out.println("Секции тестового покрытия:");
        List<Section> section = testRail.sections().list(6,6026).execute();
        section.forEach(System.out::println);

        // Кейсы сюта
        System.out.println("Список кейсов:");
        List<CaseField> customCaseFields = testRail.caseFields().list().execute();
        List<Case> case_list = testRail.cases().list(6, 6026, customCaseFields).execute();
        case_list.forEach(System.out::println);

        // Создаем новый кейс для сьюта
        //List<CaseField> customCaseFields = testRail.caseFields().list().execute();
        //Case testCase = testRail.cases().add(section.get(0).getId(), new Case().setTitle("Новый тес ткейс проверки чего-нибудь"), customCaseFields).execute();


        //Получаем  дату
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String data = formatter.format(date);

        // Создаем ран
        String run_name = "run authotest " + data;
        Run run = testRail.runs().add(project.getId(), new Run().setSuiteId(suite.getId()).setName(run_name)).execute();


        /* add test result
        List<ResultField> customResultFields = testRail.resultFields().list().execute();
        testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(1).setComment("Вроде как Passed"), customResultFields).execute();
        testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(6).setComment("Вроде как Passed w/e"), customResultFields).execute();
        testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(5).setComment("Вроде как Failed"), customResultFields).execute();
        testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(2).setComment("Вроде как Blocked"), customResultFields).execute();
        testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(4).setComment("Вроде как Retest"), customResultFields).execute();
        testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(7).setComment("Вроде как Review"), customResultFields).execute();
        testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(8).setComment("Вроде как Review Passed"), customResultFields).execute();
        testRail.results().addForCase(run.getId(), testCase.getId(), new Result().setStatusId(9).setComment("Вроде как Review Failed"), customResultFields).execute();
        */

        // close run
        testRail.runs().close(run.getId()).execute();

    }
}
