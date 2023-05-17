# packagemeasurement

This API decodes an input string and outputs an ArrayList of integers representing the total values of measured inflows for each package.

## Prerequisites

Before running the API, ensure that you have the following prerequisites installed on your machine:

- Docker: Check if Docker is installed by running the following command:
`docker --version`

- Docker Compose: Check if Docker Compose is installed by running the following command:
`docker-compose --version`

If Docker Compose is not installed, please refer to the Docker documentation to install it.

## Running the API

To run the API, follow these steps:

1. Clone the repository or download the source code.

2. Open a terminal or command prompt.

3. Navigate to the project directory.

4. Run the following command to start the API:
`docker-compose up`

This command will start the API containers and display the logs in the terminal. You should see messages indicating that the API is running on `localhost:8080`.

5. Open a web browser or use a tool like cURL or Postman to make a GET request to the API.

- URL: `http://localhost:8080`
- Query String Parameter: `input` (The input string to decode)

For example, you can open a web browser and visit `http://localhost:8080?input=your_input_string` to get the decoded result.

6. The API will respond with an ArrayList of integers representing the total values of measured inflows for each package.

7. Once you are finished, you can stop the API by pressing `Ctrl+C` in the terminal.

That's it! You have successfully run the API using Docker Compose.

If you have any issues or questions, please feel free to contact us.
