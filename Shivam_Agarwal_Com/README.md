# Assignment - TrueCaller

Project Specifications-
The app should provide a button to load the content of a website below and perform 3 tasks in
parallel. The app should display the result of each task as soon as it is done. You can choose how
you want to display the result.
URL: https://www.truecaller.com/blog/life-at-truecaller/life-as-an-android-engineer
Consider the content of the website as plain text.

1. Truecaller15thCharacterRequest:
   ● Find the 15th character and display it on the screen
2. TruecallerEvery15thCharacterRequest:
   ● Find every 15th character (i.e. 15th, 30th, 45th, etc.) and display the array on the screen
3. TruecallerWordCounterRequest:
   ● Split the text by whitespace characters (i.e. space, tab, line break, etc.), count the
   occurrence of every unique word (case insensitive) and display the count for each word
   on the screen
   ● Example: "<p> Truecaller Hello World </p>" should produce +1 for each of these:
   "<p>", "Truecaller", "Hello", "World", and "</p>".



Solution:
Tech Requirement
• Architecture - MVVM with Clean Architecture
• Network call - Retrofit
• Dependency Injection - Hilt
• ViewBinding
• Coroutine - Flow API
• ViewModel & Livedata


Description:
1. Created basic UI to show data
2. There is only one API to get data for all three Usecases. So I am calling this API once and
   showing data based on usecases.






