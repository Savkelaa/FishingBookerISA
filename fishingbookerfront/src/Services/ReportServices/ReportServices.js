const axios = require("axios");

const reportServices = {
  getAllInstructorBadReports: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}badInstructorReports`);
  },

  updateInstructorReport: (report) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}instructorReports/${report.id}`,
      report
    );
  },

  createInstructorReport: (report) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}instructorReports`,
      report
    );
  },

  createCottageOwnerReport: (report) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}cottageOwnerReport`,
      report
    );
  },
};

export default reportServices;
