# Journal

Document project progress, the development process, accomplishments, snags, and time spent on this class. You may use whatever format suits you, as long as this information is shared. 

[Time Log](TimeLog.md)

### Week 1

1/18/2016 

Tasks Completed:
 * Chose a project goal
 * Reviewed SkinnySki.com 
 * Created this repository 
 * Wrote the problem statement
 * Started documenting the project plan
 * Began listing technologies and how they fit in this project
 
I have a solid idea for the individual project and am anxious to get started. One area I struggled with a little bit was getting specific on the project plan with regard to what exactly I'll be doing in the later weeks. I think once I have the screen layout complete this coming week, it will make it much easier to add more detail to the plan. 

I also started looking at a few different services that could be used:

* Here's the home page for the google maps web services: https://developers.google.com/maps/web-services/overview?hl=en This can be used to display a map of the trail location.
* A service to identify the current snow depth, most recent snowfal, etc.  Looks like this data is available: http://www.weather.gov/nerfc/snow, but I did not quickly find a service that returns the data. Will keep searching. Scraping the details from something like this, may work as well: http://www.nohrsc.noaa.gov/nsa/reports.html?region=National&var=snowdepth&dy=2016&dm=1&dd=24&units=e&sort=value&filter=0
* A service for current weather conditions migth be helpful as well. http://openweathermap.org looks promising and they have a free tier. There's also some integration with google maps, so I think I may be able to project weather data over the google map?

### Week 2

1/29/2016

Where did the week go?!?!  Prep for classes and my grad class took up a fair amount of time this week, but I set aside a little time today to work on the screen design. I had said I was not going to go fancy with the design and would just whiteboard it or draw on paper, but when I sat down to do it, I really did want to do something a little prettier, AND using a tool allows copy and paste, which is faster than redrawing (for me anyway). So... I did a quick search of free wireframe tools available. One of the first I found with a "free wireframe tool" Google search was https://wireframe.cc/pro/.  I signed up for the 7-day free trial, learned the ins and outs of the tool, and created my wireframes in about 1 1/2 hours.  You can view the wireframes, complete with links here: https://wireframe.cc/pro/pp/af3ee6b9238237 and I also exported them as images into this repository since after the 7-day trial I'm not sure if I'll still be able to use that link or not.   I felt like this was a valuable process - it forced me to think about what I really want/need to capture and how to structure the site itself. I'm sure there will be tweaks as I build it out, but I think I'm in good shape to create the real jsps and the database.  

I also created a web application project in intelliJ and connected it to my project repository in github. This way my code, journa, plan and all related documents are in a single place.  I recorded a short video as I did this so others can see one approach to adding a remote.  The git hub article on adding a remote is [here](https://help.github.com/articles/adding-a-remote/).  There are some plugins for editing/previewing markdown in intelliJ. I installed all of the recommended plugins. The HTML preview is a nice option.

Did a first deploy of my project website to openshift:  built a war in intellij of that new project and deployed to openshift using the tomcat manager.  It's not much to look at, but it's good to confirm the process. Here it is: http://tomcat-madjava.rhcloud.com/FatBikeTrailReports%5Fwar/





