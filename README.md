# Pre-work - *Note It Down*

**Note It Down** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Azhar Chara**

Time spent: **8** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [x] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [x] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [x] Add support for completion due dates for todo items (and display within listview item)
* [x] Tweak the style improving the UI / UX, play with colors, images or backgrounds

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/azharchara/NoteItDown/blob/master/Video_walkthrough.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** Android app development is really cool. We can develop eye catching UI using material design or by any other open source library. One thing really cool about android is open source and lots of developer support, you can find solution of almost everything, which I guess makes android more developer friendly.

Creating and maintaining  layouts/views are very easy, thanks to Android Studio..

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** Adapters are like binders for views specially for List view or Grid view. It binds the data set with listview. It also know the size and how to represent the each cell of list/grids.

I have used Base adapter for my custom grid view. It is important part of android structure because at runtime you can change UI elements of View Group.
The concept of convertView is introduced to increase the run time and GPU drawing efficiency of listview. It only initialize once through out the app because of its static nature and reuse the views for all data elements..

## Notes

Describe any challenges encountered while building the app.

**Answer:** As I am a beginner in android development,I faced certain challenges in implimenting listview,using DBFlow was fun.
			But implimenting an app in android is easy and friendly as compared to other platforms.	


## License

    Copyright 2017 Azhar Chara

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
