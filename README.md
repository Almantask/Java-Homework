# Pull Request

## The flow

Pull request uses the following state diagram. You can create a pull request only as draft or open. If you publish it- PR becomes open. If you abandon it- it becomes abandoned. You can abandon PR at every state, except when it's complete. When a PR passed code review (and a certain policy), it can be ready to completed. And upon completion, it becomes completed. When a PR is open, a reviewer might request for changes- then PR will change to changes requested. Completed PR could be re-opened.

<a href="https://ibb.co/mvgxwrz"><img src="https://i.ibb.co/VH5KZ0B/PR-drawio-diagrams-net.png" alt="PR-drawio-diagrams-net" border="0"></a>

## Task

Create a state machine for a Pull Request lifetime.
