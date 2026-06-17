# Manual Test Cases - Login Module

| TC ID     | Description                           | Steps                 | Expected Result               | Priority |
|------|--------------------------------------------|-----------------------|-------------------------------|-----------

| TC_001    | Valid login with admin credentials    | Enter valid           | User navigates to dashboard   |High      |
                                                    | username/password and |
                                                    | click Login           | 

| TC_002    | Login with valid username and         | Enter credentials and | Dashboard displayed           | High     |
            | password using Enter key              | press Enter           | 

| TC_003    | Invalid password                      | Enter valid username  | Error message displayed       | High     |
                                                    | and wrong password    |

| TC_004    | Invalid username                      | Enter invalid username| Error message displayed       | High     |
                                                    | and valid password    |

| TC_005    | Blank username                        | Leave username empty  | Validation message displayed  | Medium   |
                                                    | and click Login       |

| TC_006    | Blank password                        | Leave password empty  | Validation message displayed  | Medium   |
                                                    | and click Login       | 

| TC_007    | Unauthorized access to dashboard URL  | Open dashboard URL    | Redirected to login page      | High     |
            | without login                         | directly              | 

| TC_008    | Boundary value - username with        | Enter single-character| Login rejected with proper    |
            | 1 character                           | username              | validation                    | Low      |
