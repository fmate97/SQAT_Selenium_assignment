package lib;

import java.util.Arrays;
import java.util.List;

public class TestOrder {
    public List<TestOrderEnum> getTestOrder() {
        return testOrder;
    }

    private List<TestOrderEnum> testOrder = Arrays.asList(
            TestOrderEnum.SUCCESSFUL_OPEN_MAIN_PAGE,
            TestOrderEnum.SUCCESSFUL_OPEN_LOGIN_PAGE,
            TestOrderEnum.FAILED_LOGIN,
            TestOrderEnum.SUCCESSFUL_LOGIN,
            TestOrderEnum.CLICK_3D_CATEGORY,
            TestOrderEnum.BROWSER_BACK,
            TestOrderEnum.NAVIGATE_TO_SETTINGS_PAGE,
            TestOrderEnum.EDIT_BIO,
            TestOrderEnum.SIGN_OUT,
            TestOrderEnum.SUCCESSFUL_OPEN_MAIN_PAGE,
            TestOrderEnum.SUCCESSFUL_OPEN_LOGIN_PAGE,
            TestOrderEnum.SUCCESSFUL_LOGIN,
            TestOrderEnum.SUCCESSFUL_OPEN_SAVE_ASSETS_PAGE,
            TestOrderEnum.CREATE_NEW_LIST_IN_SAVE_ASSETS_PAGE,
            TestOrderEnum.SELECT_CREATED_LIST_IN_SAVE_ASSETS_PAGE,
            TestOrderEnum.DELETE_CREATED_LIST_IN_OWN_LIST_PAGE,
            TestOrderEnum.SUCCESSFUL_OPEN_MY_ASSETS_PAGE,
            TestOrderEnum.SUCCESSFUL_OPEN_PRODUCT_PAGE,
            TestOrderEnum.PRODUCT_HAS_SCREENSHOT);
}
