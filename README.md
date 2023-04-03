## HackernewsController API Documentation

### Description

This is a RESTful API controller for the Hackernews service. The API provides endpoints to retrieve top stories, past stories, and comments related to a particular story.

### Base URL

http://localhost:8081/

### Endpoints

### 1. Retrieve Top Stories Details

* **URL:** `/top-stories`
* **Method:** `GET`
* **Description:** Returns top 10 stories ranked by the score in last 15 minutes.


### 2. Retrieve Comments for a Story

* **URL:** `/comments/{storyId}`
* **Method:** `GET`
* **Description:** Returns a list of Comment objects containing username and comment text related to a particular story by passing storyId.


### 3. Retrieve All Past Stories

* **URL:** `/past-stories`
* **Method:** `GET`
* **Description:** Returns all stories previously served by top-stories.


### 4. How to run Hacker News APIS using Docker


1. Make sure you have Docker installed on your machine. 
2. Clone the GitHub repository for the Hacker News APIS to your local machine:

    ```bash
        https://github.com/jameershaikh222/hackernewsapis.git
    ```

3. Navigate to the root directory of the cloned repository:

    ```bash
    cd hackernewsapis
    ```

4. Run the Docker container by using the `docker-compose up` command:

    ```bash
    docker-compose up
    ```

    This command will start the container and run the Hacker News APIS on `localhost:8081`.

6. You can now access the APIS by opening a web browser and entering the following URL:

    ```arduino
    http://localhost:8081
    ```

    You should see a message indicating that the Welcome to Hacker News APIS..!

7. To stop the container, use the `docker-compose down` command:

    ```bash
    docker-compose down
    ```

    This command will stop and remove the container.

That's it! You have successfully run the Hacker News APIS using Docker.
