# AndroidProject and AWS application for IOT project

*This project mainly describes how the microprocessor and mobile application is connected to cloud through amazon AWS service to access and run the application.
*This project is mainly divided into three sub-modules:

1) Mobile Application
*Mobile applications (also known as mobile apps) are software programs developed for mobile devices such as smartphones and tablets. They turn mobile devices into miniature powerhouses of function and fun. Thus, in this project we have built in an mobile application named “FOOFISH”. This application mainly consists of two constructors.

-> Front End:
The front end consists of user interface (UI) which provides the user to access the application. This UI has two attributes.

-> Timer:
In this attribute there is setting for the time constraint where user can set the timer according to their need. The timer attribute has clock values as 10,20,30,40 minutes. If the timer is set as 10 min then after every 10 minutes the API’s are hit on the cloud that convey the signal to raspberry pi where the motor is deployed thus by putting the motor into action. When the user updates the timer constraint the value is stored and updated in the cloud which then conveys the updated information to raspberry pi.

-> Capture Image:
This attribute there is setting for sending the signal to the camera sensor connected to the raspberry pi where user can set time such as 10,20,30,40 minutes to take a live picture of the fish in the aquarium to monitor it. When the capture image constraint is clicked recent image is uploaded for the user. These images are stored in the cloud.

-> Back End:
In back end there is coding for timer and capture image attributes.The application interface programs are stored (API’s) in cloud where there is setting made for set (), get () attributes. These attributes are mainly responsible for the change in time constraints and updating the live images. These two attributes play an important role in maintaining the API’s on cloud.


2) Deploying on cloud services
*In order to build a connection between the mobile application and the microprocessor we are writing Application Program Interfaces(API’s) which we need to store on cloud and thus cloud acts as a center hub between the device and the microprocessor. Thus, we are using “Amazon Web Services (AWS)” which is a bundled remote computing service that provides cloud computing infrastructure over the Internet with storage, bandwidth and customized support for application programming interfaces (AWS). Here we are using a service called “Beanstalk” provided from AWS where we perform certain actions to establish a connection between the mobile app, and raspberry pi vice versa. 
*We are creating total 3 API’s:
setDeviceConfig
getDeviceConfig
To set(), get() image

3) Raspberry Pi services
*The servo motor and camera sensor is deployed on this microprocessor device i.e., raspberry pi 2. When the API is called and any kind of function assuming timer or image update is made the application program sends the signal to the microprocessor hence by hitting the servo motor and camera to work as per the update. We are using python programming to establish the connection between the API’s and the raspberry pi.

