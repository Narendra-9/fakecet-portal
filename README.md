# FakeCET Portal

FakeCET Portal is a learning project that simulates an engineering entrance-exam and counselling portal. It combines a browser-based frontend, Java implementations of the exam and counselling domain logic, and a SQL Server database schema for the portal data.

This is a learning project, inspired by the workflow of a CET examination portal. It is not an official examination service and it does not process real applications, payments, or student records.

## Built during my early learning phase

I built this project while learning in my early days. It was created without AI tools. The goal was to practise turning a multi-page idea into a working interface, modelling the portal workflow in Java, designing a relational database, and connecting user flows with JavaScript.

## Features

- Candidate and college login screens
- Registration and application flow
- Payment, certificate-upload, and web-options interfaces
- Result, rank-card, hall-ticket, and master-key pages
- Mock quiz with questions stored in the browser using `localStorage`
- Download-style rank-card and hall-ticket screens
- Responsive layouts styled with Bootstrap and custom CSS
- Java models and portal-management logic for exam and counselling workflows
- SQL Server database schema for students, applications, payments, hall tickets, marks, colleges, branches, preferences, and allotments

## Technology used

- HTML5
- CSS3
- JavaScript
- Bootstrap 5
- Java
- SQL Server (database schema)
- Browser `localStorage` for the quiz

## Run locally

Open [index.html](index.html) in a browser. It redirects to the main portal page at `FakeCet_portal/Home.html`.

For the most reliable local experience, run the project through a simple static web server instead of opening files directly.

## Deploy on GitHub Pages

This repository includes a GitHub Actions workflow at `.github/workflows/deploy-pages.yml`. Once you push it to GitHub:

1. Open the repository on GitHub.
2. Go to **Settings → Pages**.
3. Under **Build and deployment**, choose **GitHub Actions** as the source.
4. Push to the `main` branch, or run the **Deploy static site to GitHub Pages** workflow from the Actions tab.
5. GitHub will display the published site URL in the workflow result. It will normally be:
   `https://<your-github-username>.github.io/<repository-name>/`

The site opens at that URL and redirects to the FakeCET home page.

## Project structure

```text
FakeCet_portal/
├── Home.html              # Main portal page
├── Css/                   # Stylesheets and image assets
├── JavaScript/            # Page interactions and navigation
└── Quiz/                  # Mock quiz pages and scripts
src/                       # Java exam and counselling portal logic
FakeCet_DB.sql             # SQL Server database schema
```

## Notes

GitHub Pages hosts static files only. It will publish the HTML, CSS, JavaScript, and assets in this repository. The Java source and SQL Server database schema are included as part of the project, but they cannot run on GitHub Pages. A production portal would need a hosted Java backend, SQL Server database, authentication, file storage, and a payment provider.

## License

This project is shared for learning and portfolio purposes. Add a license file if you want to specify reuse terms.
