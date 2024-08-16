# Schedule Management API

## API 명세서

### 1. 일정 작성
- **URL**: `/api/schedules`
- **Method**: `POST`
- **Request Body**:
    ```json
    {
        "task": "Task Description",
        "assignee": "Assignee Name",
        "password": "Password"
    }
    ```
- **Response**:
    ```json
    {
        "id": 1,
        "task": "Task Description",
        "assignee": "Assignee Name",
        "createdDate": "2024-08-16T12:00:00",
        "modifiedDate": "2024-08-16T12:00:00"
    }
    ```

### 2. 일정 조회
- **URL**: `/api/schedules/{id}`
- **Method**: `GET`
- **Response**:
    ```json
    {
        "id": 1,
        "task": "Task Description",
        "assignee": "Assignee Name",
        "createdDate": "2024-08-16T12:00:00",
        "modifiedDate": "2024-08-16T12:00:00"
    }
    ```

### 3. 일정 목록 조회
- **URL**: `/api/schedules`
- **Method**: `GET`
- **Request Params**:
   - `modifiedDate` (Optional)
   - `assignee` (Optional)
- **Response**:
    ```json
    [
        {
            "id": 1,
            "task": "Task Description",
            "assignee": "Assignee Name",
            "createdDate": "2024-08-16T12:00:00",
            "modifiedDate": "2024-08-16T12:00:00"
        }
    ]
    ```

### 4. 일정 수정
- **URL**: `/api/schedules/{id}`
- **Method**: `PUT`
- **Request Params**:
   - `password`: Password for authorization
- **Request Body**:
    ```json
    {
        "task": "Updated Task Description",
        "assignee": "Updated Assignee Name"
    }
    ```
- **Response**:
    ```json
    {
        "id": 1,
        "task": "Updated Task Description",
        "assignee": "Updated Assignee Name",
        "createdDate": "2024-08-16T12:00:00",
        "modifiedDate": "2024-08-16T13:00:00"
    }
    ```

### 5. 일정 삭제
- **URL**: `/api/schedules/{id}`
- **Method**: `DELETE`
- **Request Params**:
   - `password`: Password for authorization
- **Response**: `204 No Content`
