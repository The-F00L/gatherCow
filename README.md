### One rule them all

- main goal:
    - Gather as information as possible with only one command or script(bash,batch,powershell script are not allowed,com. limit: 64)
- task 1:
    - gcc and jre [Done]
- task 2:
    - user flag ->CTF{36beede8d28ef2a3}[Done]
- task 3:
    - collect info -> submit -> flag[Done]
- task 4:
    - bypass os rules
- task 5:
    - spawn reverse shell
- task 6:
    - collect root flag

```shell
cat stub.sh java.jar > app && chmod +x app
```