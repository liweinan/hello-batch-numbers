```bash
curl http://localhost:8080/hello-batch-numbers/start
```

---

```bash
[standalone@localhost:9990 /] /subsystem=batch-jberet/jdbc-job-repository=jdbc:add(data-source=ExampleDS)
{"outcome" => "success"}

[standalone@localhost:9990 /] /subsystem=batch-jberet:write-attribute(name=default-job-repository,value=jdbc)
{
    "outcome" => "success",
    "response-headers" => {
        "operation-requires-reload" => true,
        "process-state" => "reload-required"
    }
}

[standalone@localhost:9990 /]
```