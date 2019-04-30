#language:en 
@notImplemented
Feature: Add item Post

    Background: Use endpoint posts
        Given use endpoint add posts

    Scenario Outline: Add item Post
        When add item Post with <title> and <body>
        Then I see inserted item

        Examples:
        | title        | body                           |
        | "API Testing"| "Example testing API with Ruby"|

    Scenario Outline: Not add item Post
        When add item Post without <title> or <body>
        Then I receive invalid action message

        Examples:
        | title        | body                           |
        | "API Testing"| ""                             |
        | ""           | "Example testing API with Ruby"|