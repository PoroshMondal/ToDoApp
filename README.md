# ToDoApp 
ToDoApp is a simple application developed using Kotlin and the latest Android Components.

## Branch Information
- todo-without-Di
    - ToDo app all the feature is implemented except DI
    - Dependency Injection is not used

## Design Pattern
- MVVM
- Repository pattern for local db operations

## Features and components 
- Data Binding functionality added
- Designed the NewToDo screen
    - Input Box
    - Radio Buttons
    - Save Button to save the ToDo data 
- Implement the Date Picker dialog
- Implement the Time Picker dialog
- Navigation component - navigation Graph used for navigation
- RecyclerView
- Checkbox 
- Delete confirmation dialog

## Binding
- Layout binding used to bind the layout
- Data binding used to bind the ToDo RecyclerView adapter

## Database
- Room Library used for local db
- Repository design pattern used with mvvm to do db operations
- Operations 
    - Insert
    - Update
    - Delete
    - Query

## Background Operation
- Coroutine used to do db operations
- WorkManager used for push notification
     - This is one time work request
     - Pop up the ToDo notification on that specific time
