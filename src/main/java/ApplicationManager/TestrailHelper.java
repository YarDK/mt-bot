package ApplicationManager;

import Models.TestrailData;
import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestrailHelper {

    private static TestrailData testrailData = new TestrailData();

    public TestrailData getTestrailData() {
        return testrailData;
    }

    public void init() {
        Properties properties = new Properties();
        File file_properties = new File("src/main/resources/testrail.properties");
        try {
            properties.load(new FileReader(file_properties));
            // Закгрузка данных проперти
            testrailData
                    .withUser(properties.getProperty("username"))
                    .withPassword(properties.getProperty("password"))
                    .withTestrail_url(properties.getProperty("url"))
                    .withProject_id(properties.getProperty("project_id"))
                    .withSuite_id(properties.getProperty("suit_id"));

            // Выставление ID для резульатов выполения кейсов
            testrailData
                    .withPassed_id(properties.getProperty("passed"))
                    .withPassed_we_id(properties.getProperty("passed_we"))
                    .withFailed_id(properties.getProperty("failed"))
                    .withBlocked_id(properties.getProperty("blocked"))
                    .withRetest_id(properties.getProperty("retest"))
                    .withReview_id(properties.getProperty("review"))
                    .withReview_passed_id(properties.getProperty("review_passed"))
                    .withReview_failed_id(properties.getProperty("review_failed"));

            // Построение проекта
            TestRail testRail = TestRail
                    .builder(testrailData.getTestrail_url(), testrailData.getUser(), testrailData.getPassword())
                    .applicationName("TestRail MangoQA")
                    .build();

            // Получение проекта и сьюта
            Project project = testRail.projects().get(testrailData.getProject_id()).execute();
            Suite suite = testRail.suites().get(testrailData.getProject_id()).execute();

            // Полчение кейсов
            List<CaseField> customCaseFields = testRail.caseFields().list().execute();
            List<Case> case_list = testRail
                    .cases()
                    .list(testrailData.getProject_id(), testrailData.getSuite_id(), customCaseFields)
                    .execute();

            // Сохранение данных тестового набора
            testrailData
                    .withTestRail(testRail)
                    .withProject(project)
                    .withSuite(suite)
                    .withCases(case_list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startRun() {
        //Получаем  дату
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String data = formatter.format(date);

        // Создаем ран
        String run_name = "Run authotest " + data;
        Run run = testrailData.getTestRail()
                .runs()
                .add(testrailData.getProject_id(), new Run().setSuiteId(testrailData.getSuite_id()).setName(run_name))
                .execute();

        testrailData.withRun(run);
    }

    public void setResultCase(int case_id, String result, String comment){

        // Определение ID статуса результата выолнения кейса
        int status_id = 0;
        switch (result.toLowerCase()) {
            case "passed":
                status_id = testrailData.getPassed_id();
                break;
            case "passed_we":
                status_id = testrailData.getPassed_we_id();
                break;
            case "failed":
                status_id = testrailData.getFailed_id();
                break;
            case "blocked":
                status_id = testrailData.getBlocked_id();
                break;
            case "retest":
                status_id = testrailData.getRetest_id();
                break;
            case "review":
                status_id = testrailData.getReview_id();
                break;
            case "review_passed":
                status_id = testrailData.getReview_passed_id();
                break;
            case "review_failed":
                status_id = testrailData.getReview_failed_id();
                break;
            default:
                break;
        }

        if(testrailData.getTestRail() != null) {
            // Поля данных (статус, id, название и тд)
            List<ResultField> customResultFields = testrailData.getTestRail().resultFields().list().execute();

            // Добавление результата
            testrailData.getTestRail()
                    .results()
                    .addForCase(
                            testrailData.getRun().getId(),
                            case_id,
                            new Result().setStatusId(status_id).setComment(comment),
                            customResultFields)
                    .execute();

        } else {
            System.out.println("\nTestRail not set. Skip set result.");
        }
    }

    public void closeRun(){
        // close run
        testrailData.getTestRail().runs().close(testrailData.getRun().getId()).execute();
    }

}
