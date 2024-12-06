const log = document.querySelector('.LOGIN');
const selection = document.querySelector('.SELECTION');
const signInButton = document.getElementById('Sign-in-button');
const FTButton = document.getElementById('full-time');
const PTButton = document.getElementById('part-time');
const FTForm = document.getElementById('full-time-form');
const PTForm = document.getElementById('part-time-form');
const PTSubmitButton = PTForm.querySelector('button');
selection.style.display = 'none';
FTForm.style.display = 'none';
PTForm.style.display = 'none';

signInButton.addEventListener('click', () => {
    log.classList.add('fade-out');
    setTimeout(() => {
        log.style.display = 'none';
        selection.style.display = 'flex';
        selection.classList.add('move-up');
    }, 1000);
});

FTButton.addEventListener('click', () => {
    selection.classList.add('fade-out');
    setTimeout(() => {
        selection.style.display = 'none';
        FTForm.style.display = 'block';
        FTForm.classList.add('fade-in');
    }, 1000);
});

PTButton.addEventListener('click', () => {
    selection.classList.add('fade-out');
    setTimeout(() => {
        selection.style.display = 'none';
        PTForm.style.display = 'block';
        PTForm.classList.add('fade-in');
    }, 1000);
});

PTSubmitButton.addEventListener('click', (event) => {
    event.preventDefault();

    const ratePerHour = parseFloat(document.getElementById('rate-per-hour').value);
    const workDays = parseInt(document.getElementById('work-days').value);
    const overtime = parseInt(document.getElementById('overtime').value);

    if (isNaN(ratePerHour) || isNaN(workDays) || isNaN(overtime)) {
        alert('Please enter valid numbers for all fields.');
        return;
    }

    const basicPay = ratePerHour * workDays * 8;
    const overtimePay = ratePerHour * (overtime * 1.25);
    const totalSalary = basicPay + overtimePay;

    // TAXES
    const sssRate = 0.11;
    const philHealthRate = 0.04;
    const pagIbigRate = 0.02;
    const sssContribution = totalSalary * sssRate;
    const philHealthContribution = totalSalary * philHealthRate / 2;
    const pagIbigContribution = totalSalary * pagIbigRate;

    const resultDiv = document.createElement('div');
    resultDiv.classList.add('salary-result');
    resultDiv.innerHTML = `
        <h3>Salary</h3>
        <p><strong>Basic Pay:</strong> ₱${basicPay.toFixed(2)}</p>
        <p><strong>Overtime Pay:</strong> ₱${overtimePay.toFixed(2)}</p>
        <p><strong>Total Salary:</strong> ₱${totalSalary.toFixed(2)}</p>
        <p><strong>SSS Contribution (11%):</strong> ₱${sssContribution.toFixed(2)}</p>
        <p><strong>PhilHealth Contribution (2%):</strong> ₱${philHealthContribution.toFixed(2)}</p>
        <p><strong>Pag-IBIG Contribution (2%):</strong> ₱${pagIbigContribution.toFixed(2)}</p>
    `;
    PTForm.appendChild(resultDiv);
});
