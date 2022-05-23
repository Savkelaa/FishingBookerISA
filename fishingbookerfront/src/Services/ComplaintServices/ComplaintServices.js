const axios = require("axios");

const complaintServices = {
  getAllFishingClassInstructorComplaints: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}instructorComplaints`);
  },

  getAllInstructorComplaintRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}instructorComplaintRequests`
    );
  },

  updateInstructorComplaint: (complaint) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}instructorComplaints/${complaint.id}`,
      complaint
    );
  },

  createInstructorComplaint: (complaint) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}instructorComplaints`,
      complaint
    );
  },
};

export default complaintServices;
