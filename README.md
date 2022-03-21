## Authors:
#### Cathrine B. Monsen, Iselin Thorsen Nilsen, Isabella Nesheim

## Test using Gradlew:

Using: running command: gradlew.bat cAT

## Test Summary


| Test          |   Failures    |    Duration   |    Successful |
| ------------- |:-------------:|:-------------:|:-------------:|
|    5          |       0       | 16.44s        |     100%      |


## Packages
| Package  | Tests | Failures   | Duration |
| ------------- |:-------------:|:-------------:|:-------------:|
|       default-package              |       0       | 0         |    -   |
|    com.ebookfrenzy.cahiss          |       0       | 16.44s    | 100%   |

## Classes
| Package  | Tests | Failures   | Duration |
| ------------- |:-------------:|:-------------:|:-------------:|
|    com.ebookfrenzy.cahiss.AddStudentActivityTest    |       1       | 0   |  8.20s    |
|    com.ebookfrenzy.cahiss.DatabaseActivityTest      |       1       | 0    | 7.376s   |
|    com.ebookfrenzy.cahiss.MainActivityTest          |       1       | 0    | 9.83s    |
|    com.ebookfrenzy.cahiss.QuizActivityTest          |       2       | 0    | 11.275s  |

## APK's used
Gradle uses "app-debug-androidTest.apk" in this APK, and wil test relevant test-classes.

## adb command used
Installing the test: adb am instrument
Running the entire test-package: adb shell am instrument -w
com.ebookfrenzy.cahiss.tests/android.support.test.runner.AndroidJUnitRunner

To run one test-class (example: MainActivityTest): adb shell am instrument
-w
-e class  com.ebookfrenzy.cahiss.tests.MainActivityTest
com.example.quizapp_oblig1.tests/android.support.test.runner.AndroidJUnitRunner
