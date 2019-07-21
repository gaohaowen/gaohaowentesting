# Weather Search Demo

This demo is using **SpringBoot and Vue**.  CI/CD is using **AWS Pipeline**.

## Code structure

The application contains controller, service and dao. They are connected by interface and spring annotation. When springBoot starts up, config class will automatically load the city list from a json file, so that we can easily expands city list.
Weather api requires a private key which we persist in file system so we could pretect it safely.
The application uses Gson to do json/pojo mapping work, and has exception handler and  the unified response.

The applicaiton try to use Java8 new feature in ApplicationConfig.

The application integrate frontend code which is in static folder.
Fronend code refer to:
https://github.com/gaohaowen/weatherSearchFront

## Code testing

Use Mockito to do Controller and ExceptionHandler testing.

## CI/CD
Use AWS Pipeline to build this application. when user try to commit/merge code into master branch, AWS Pipeline will build automatically.
Refer to https://docs.aws.amazon.com/zh_cn/codepipeline/latest/userguide/welcome.html
One thing to pay attention is:
need add a proxy when creating EC2.
https://docs.aws.amazon.com/zh_cn/codedeploy/latest/userguide/instances-ec2-create.html


