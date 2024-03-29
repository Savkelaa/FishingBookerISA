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

  getAllBoatComplaintRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}boatComplaints`
    );
  },

  getAllCottageComplaintRequests: () => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottageComplaints`
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

  createBoatComplaint: (complaint) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}boatComplaints`,
      complaint
    );
  },


  createCottageComplaint: (complaint) => {
    return axios.post(
      `${process.env.REACT_APP_API_URL}cottageComplaints`,
      complaint
    );
  },
};

export default complaintServices;
