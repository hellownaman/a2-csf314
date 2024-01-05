[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/tI1Hnuga)
# A2-PersistUI

### a. Basic Information

**Name of the Project** - Dice Games App

**Name of Students**: Naman Agarwal - Ayush Bhardwaj

**BITS IDs**: 2021A7PS2668G - 2021A7PS2634G

**Emails**: f20212668@goa.bits-pilani.ac.in - f20212634@goa.bits-pilani.ac.in

### b. What does the app do? Any known bugs?

The Dice Games App is a simple Android application that allows users to simulate rolling a dice and earn coins based on certain rules. The app provides a user interface (UI) for rolling the dice, keeping track of the number of times a six is rolled, displaying the total number of rolls, and calculating the earned coins based on specific rules. The app also includes a toast notification for congratulating the user when they earn coins.

There are currently no known bugs or issues in the app.

### c. Description of completed tasks and steps followed to achieve them

**Task 1 - Developing WalletActivity**

- We store the views of each display field or button under named variables in the **WalletActivity.java** file.
- Declared a View Model which will help persist the UI state across device rotations.
- Used **onSaveInstanceState** to store all ui fields and restore in case of process death.
- Called the appropriate functions for setting the die and winning value.
- Called the **rollDie** method on clicking the Die.

**Task 2 - Adding Toast Mechanism**

- We implemented the make toast method to fill in with the message and display duration.
- The message was displayed on clicking the die button and on getting 6 the message was displayed.

**Task 3 - Win Rate Stats added**

- Implemented the functions to keep a count of total number of rolls and number of times we got 6.
- The respective fields of displaying the above mentioned stats were also added to the activity file in both portrait and landscape mode.
- Maintained UI state across process death by using **Bundle** and **onSaveInstanceState**.

**Task 4 - Implementing the Double roll logic**

- Implemented a function to keep track of the previous roll and update the balance accordingly.
- Added a scope to keep track of double sixes and double non sixes.
- The respective fields of displaying the above mentioned stats were also added to the activity file in both portrait and landscape mode.
- Maintained UI state across process death by using **Bundle** and **onSaveInstanceState**.

### d. Testing using written test cases using Mockito

- We employed a test-driven approach, crafting and running test cases for edge scenarios.
- UI tests were consistently written and executed after each development step.
- WalletViewModelTest ran successfully with all tests passing.
- This iterative testing process improved our understanding of the app's functionality and helped identify and address corner cases, enhancing app stability.

### e. Accessibility

- We tested the application with the **TalkBack** service enabled. This service proved to be user-friendly, providing clear guidance at each step. TalkBack correctly identified the wager input element as an input box, and it also vocalized the default hint text within the element. Furthermore, a single tap on the displayed result effectively conveyed the information to the user. This experience allowed us to easily discern the location of our finger on the screen and determine which element was currently active. In summary, TalkBack serves as an invaluable accessibility tool, greatly assisting individuals with visual impairments in their app usage.

- We conducted an evaluation using the **Accessibility Scanner** on the application, which identified the following issue:
- Item Descriptions - Multiple items shared identical descriptions.
- To address this concern, we resolved it by incorporating seven distinct values within the **strings.xml** file and employing them as **contentDescription** attributes for specific elements.

### f. Approximate number of hours it took to complete the assignment

**Writing Code, Testing and Solving Accessibility Issues** -> 6 hours

**Documentation** -> 1 hour

**Total Time = 7 hours**

### g. To what extent did we use pair programming on this assignment:

**On a scale of 1 to 5, It would be 4**

### h. Difficulty of Assignment

On a scale of 1 to 10, We would rate the difficulty of the assignment as **5**.

We found the assignment to be of moderate complexity, with a notable challenge being the management of UI state during device rotations. Completing this assignment provided us with valuable insights into fundamental functionalities and commonly employed methods in app development.
