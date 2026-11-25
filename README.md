# Flashcards

## Table of Contents

- [Team Information](#team-information)
- [Project Description](#project-description)
- [User Stories](#user-stories)
- [Use Cases](#use-cases)
- [Minimal Viable Product (MVP)](#minimal-viable-product-mvp)
- [Entities](#entities)
- [API Usage](#api-usage)
- [Design Diagrams](#design-diagrams)
- [How to Run](#how-to-run-complete-later-after-implementation)
- [Notes](#notes)

---

## Team Information

### Team Members
  | Team Member | GitHub |
  |-------------|--------------|
  | Maria Shamshurina | [mashasci-hash](https://github.com/mashasci-hash)|
  | Janica Krznaric | [jkrz15](https://github.com/jkrz15)|
  | Margaret Du | [margaretdu](https://github.com/margaretdu)|
  | Roy Chen | [roy-chen2](https://github.com/roy-chen2)|
---
## Project Description
### Domain: Education
A flashcard application that allows users to create, manage and organize flashcard decks, with questions and answers. 
These flashcards can be used in a study/quiz mode to look at the questions and double check answers. The flashcard decks
can be imported and exported through CSV files to support sharing and external editing. Flashcard decks can be searched 
for to find which ones are needed.

---
## User Stories
### User Story 1
As a user, I want to create, edit delete, and update flashcard decks and flashcards so that I can keep my flashcards organized by class, course, or personal preference.
- Corresponding Use Cases: 
  - Part a)
    - Create: [Use Case 1](#use-case-1), [Use Case 5](#use-case-5)
    - Delete: [Use Case 3](#use-case-3), [Use Case 7](#use-case-7)
  - Part b)
    - Edit: [Use Case 2](#use-case-2), [Use Case 6](#use-case-6)
### User Story 2
As a user, I want to view and study flashcard decks in list and study mode so that I can review and test my knowledge.
- Corresponding Use Cases: [Use Case 8](#use-case-8-view-all-flashcard-decks), [Use Case 9](#use-case-9-view-and-study-flashcard-deck)
### User Story 3
As a user, I want to view the definition of an unfamiliar word in a flashcard in a deck so that I can quickly understand the term to aid in my studying.
- Corresponding Use Cases: [Use Case 8](#use-case-8), [Use Case 9](#use-case-9)
### User Story 4
As a user, I want to import and export flashcards so that I can send flashcards to other people or create cards using external editors.
- Corresponding Use Cases: [Use Case 12](#use-case-12), [Use Case 13](#use-case-13)
### User Story 5
As a user, I want to search different decks and flashcards so that I can find specific study materials. (extra)

---
## Use Cases
### Use Case 1
Create Deck
### Use Case 2
Edit Deck
### Use Case 3
Delete Deck
### Use Case 4
Create Flashcard
### Use Case 5
Edit Flashcard
### Use Case 6
Delete Flashcard
### Use Case 8: View all flashcard decks
**Lead:** Janica Krznaric <br>
**Success outcome:** The user can see all available flashcard decks

<details>
<summary>Detailed Use Case</summary>

**Primary Actor:** User viewing all flashcard decks

**Preconditions:** User is on the home page

**Trigger:** the User is on the home page

**Main success scenario:**
1. User is looking at the home page
2. User can see a list of all flashcard decks, with each decks name and the number of cards in the deck

**Extensions:**
- 2a. If there are no flashcard decks the system will explain this to the user
</details>

### Use Case 9: View and Study flashcard deck
**Lead:** Janica Krznaric <br>
**Success outcome:** user is viewing the flashcard deck and can see all cards within the deck, user can flip cards and move through cards to study.

<details>
<summary>Detailed Use Case</summary>

**Primary Actor:** User viewing the flashcard deck

**Preconditions:**
1. There exists a flashcard deck to view
2. If study view was selected the deck must be non-empty

**Trigger:** selecting a flashcard deck on the home page and selecting to view the deck or to study the deck

**Main success scenario:**
1. The user selects flashcard deck to be viewed.
2. The user selects study mode or view mode.
3. The user can view the name of the deck and how many cards are in the deck.

User selected Study:
4. The user can view the question on a flashcard in the deck and flip the flashcard to see the answer.
5. The user can move between cards in the deck and see their progress of what number card they are on.

User selected View:
4. The user can see all the flashcards in the deck each with their question and answer.
5. The user can select a card to keep track of which one they are on.

**Extensions:**
- 2a. If study mode was selected and the deck is empty the system will inform the user that the deck cannot be studied.
- 4a. If view mode was selected the system will inform the user that the deck is empty and there are no flashcards to be viewed.

**Notes:**
This was included as one use case since the same interactor and logic is used for both views.
</details>

### Use Case 11
Search Decks
### Use Case 12
Import Flashcards from CSV
### Use Case 13
Export Flashcards to CSV

---
## Minimal Viable Product (MVP)
| Team Member | MVP User Story/Cases |
|-------------|--------------|
| Maria | [User Story 1:](#user-story-1) Part a) Create and Delete |
| Janica | [User Story 2](#user-story-2): View and Study flashcards and decks |
| Margaret | [User Story 3](#user-story-3): Dictionary API, [User Story 1](#user-story-1): Part b) Edit |
| Roy | [User Story 4](#user-story-4): Data persistence: Import and Export |
---
## Entities
### Entity 1
**Flashcard**: represents a flashcard in a Deck.
- variables: 
  - `String question` the question of the flashcard
  - `String answer` the corresponding answer to the question of the flashcard
- methods: has both getter and setter methods for each variable
### Entity 2
**Deck**: represents a collection of Flashcards.
- variables:
  - `String name` the name of the deck
  - `ArrayList<Flashcard> flashcards` a list of Flashcard objects in the Deck
- methods:
  - has getter method for name and the flashcard count.
  - has setter method for name
  - has an add and remove method for a Flashcard


---
## API Usage
**API Name:**

**Documentation:** [Link]

**How it is used in the program:**

---
## Design Diagrams
### UML Class Diagram

---
### Sequence Diagrams

---
## How to Run
[Instructions for running the program.]

---
## Notes
[Any additional project information.]