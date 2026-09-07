# Contributing to VoltX

VoltX is developed using an engineering-first workflow. The goal is to make architectural decisions explicit, reviewable, and reusable.

## Engineering workflow

Use this flow for meaningful changes:

1. Requirement
2. Design
3. Architecture decision
4. Implementation
5. Testing
6. AI Code Review
7. Human Code Review
8. Security Review
9. Performance Review
10. Refactoring
11. Deployment

Not every change needs every stage in equal depth. The risk and scope of the change determine the level of review required.

## Branching strategy

- `main` is the stable integration branch.
- Create a short-lived branch for each change.
- Prefer branch names such as:
  - `feature/<name>`
  - `fix/<name>`
  - `refactor/<name>`
  - `docs/<name>`
  - `chore/<name>`
- Do not work directly on `main` for normal feature development.

## Pull requests

Every non-trivial change should use a pull request.

A pull request should explain:

- What changed
- Why it changed
- Which problem it solves
- Alternatives considered
- Trade-offs
- Testing performed
- Security implications
- Performance implications
- Operational or production impact

## Architecture decisions

For architecture-impacting work, explicitly answer:

- Why this approach?
- Why not the main alternatives?
- What problem does it solve?
- What are the trade-offs?
- What happens under failure?
- What happens at scale?
- How will we observe and debug it?

## Commit messages

Use clear, imperative commit messages with a small scope. Examples:

- `feat: add charger domain model`
- `fix: prevent duplicate session creation`
- `refactor: isolate energy calculation`
- `test: cover charger availability rules`
- `docs: explain charging session lifecycle`
- `chore: update repository configuration`

## Review mindset

Reviews should look beyond syntax and happy-path behavior. Consider correctness, design, architecture, security, performance, concurrency, error handling, testing, maintainability, scalability, observability, database behavior, API design, failure scenarios, and business requirements.
