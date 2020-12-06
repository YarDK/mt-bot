package Models;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;

import java.util.List;

public class TestrailData {

    private String user;
    private String password;
    private String testrail_url;

    private int project_id;
    private int suite_id;

    private TestRail testRail;
    private Project project;
    private Suite suite;
    private List<Case> cases;
    private Run run;

    private int passed_id;
    private int passed_we_id;
    private int failed_id;
    private int blocked_id;
    private int retest_id;
    private int review_id;
    private int review_passed_id;
    private int review_failed_id;


    // Getters
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getTestrail_url() {
        return testrail_url;
    }

    public int getProject_id() {
        return project_id;
    }

    public int getSuite_id() {
        return suite_id;
    }

    public TestRail getTestRail() {
        return testRail;
    }

    public Project getProject() {
        return project;
    }

    public Suite getSuite() {
        return suite;
    }

    public List<Case> getCases() {
        return cases;
    }

    public Run getRun() {
        return run;
    }

    public int getPassed_id() {
        return passed_id;
    }

    public int getPassed_we_id() {
        return passed_we_id;
    }

    public int getFailed_id() {
        return failed_id;
    }

    public int getBlocked_id() {
        return blocked_id;
    }

    public int getRetest_id() {
        return retest_id;
    }

    public int getReview_id() {
        return review_id;
    }

    public int getReview_passed_id() {
        return review_passed_id;
    }

    public int getReview_failed_id() {
        return review_failed_id;
    }


    // Setters
    public TestrailData withUser(String user) {
        this.user = user;
        return this;
    }

    public TestrailData withPassword(String password) {
        this.password = password;
        return this;
    }

    public TestrailData withTestrail_url(String testrail_url) {
        this.testrail_url = testrail_url;
        return this;
    }

    public TestrailData withProject_id(String project_id) {
        this.project_id = Integer.parseInt(project_id);
        return this;
    }

    public TestrailData withSuite_id(String suite_id) {
        this.suite_id = Integer.parseInt(suite_id);
        return this;
    }

    public TestrailData withTestRail(TestRail testRail) {
        this.testRail = testRail;
        return this;
    }

    public TestrailData withProject(Project project) {
        this.project = project;
        return this;
    }

    public TestrailData withSuite(Suite suite) {
        this.suite = suite;
        return this;
    }

    public TestrailData withCases(List<Case> cases) {
        this.cases = cases;
        return this;
    }

    public TestrailData withRun(Run run) {
        this.run = run;
        return this;
    }

    public TestrailData withPassed_id(String passed_id) {
        this.passed_id = Integer.parseInt(passed_id);
        return this;
    }

    public TestrailData withPassed_we_id(String passed_we_id) {
        this.passed_we_id = Integer.parseInt(passed_we_id);
        return this;
    }

    public TestrailData withFailed_id(String failed_id) {
        this.failed_id = Integer.parseInt(failed_id);
        return this;
    }

    public TestrailData withBlocked_id(String blocked_id) {
        this.blocked_id = Integer.parseInt(blocked_id);
        return this;
    }

    public TestrailData withRetest_id(String retest_id) {
        this.retest_id = Integer.parseInt(retest_id);
        return this;
    }

    public TestrailData withReview_id(String review_id) {
        this.review_id = Integer.parseInt(review_id);
        return this;
    }

    public TestrailData withReview_passed_id(String review_passed_id) {
        this.review_passed_id = Integer.parseInt(review_passed_id);
        return this;
    }

    public TestrailData withReview_failed_id(String review_failed_id) {
        this.review_failed_id = Integer.parseInt(review_failed_id);
        return this;
    }
}
