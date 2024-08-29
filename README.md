Start the server:

```bash
$ mvn wildfly:run
```

---

Start the job:

```bash
➤ curl http://localhost:8080/hello-batch-numbers/start
Started job execution: numbers 1
```

--

Stop the job:

```bash
➤ curl 'http://localhost:8080/hello-batch-numbers/stop?id=1'
1: STOPPED
```

---

Configure the H2 database according to the instructions here:

- https://jberet.org/configure-jberet-wildfly-jdbc-job-repo/

And verify that the job execution is stopped correctly:

<img width="1678" alt="image" src="https://github.com/user-attachments/assets/c5df4773-9d07-4062-b73c-109782faedf0">

