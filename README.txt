Narrative:
    Kyle, Nate, and I are part of a large Game Dev't company, where our team and many other teams were tasked with designing a combat engine.
    Each team was also tasked with pitching the design to the Seniors in the company, and the design they find works the best will be implemented into the final game.

Components:
    There are 3 main types of components in our projects: the UI components, the Entity components, and the Game Loop components
        UI Components:
            These are the components that relate to outputting prompts to the user through the console, this type consists of mainly:
                - GUI (any of the classes within the package can import this class and access its methods and attributes)
                - MainMenu
        Entity Components:
            These are the components that relate to defining the behaviors and stats of the entities within the game loop, these are:
                - IEntity
                    - Monster (all the child classes of Monster class override the specialAttack() method for their own versions of a special move)
                        - Lesser Demon
                        - Succubus Demon
                        - Emperor Demon
                        - Hyperion Demon
                    - Player (all the child classes of Player class add to or subtract from the default stats in the constructor for stats that better fit each type of player)
                        - Assassin
                        - Druid
                        - Mage
                        - Warrior
            Both the main Player and Monster classes implement from the IEntity interface, and all the specific player and monster classes extend from their respective parents
        Game Loop Components:
            These are the components that actually run the sim, these components are in charge of keeping the sim running until either the player or the monster dies, and these are:
                - Program
                - Simulator

    (The Unit Testing class was used for Debug purposes.)