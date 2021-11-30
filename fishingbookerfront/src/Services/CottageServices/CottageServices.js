const axios = require("axios");

const cottageServices = {
  getAllCottages: () => {
    return axios.get(`${process.env.REACT_APP_API_URL}cottages`);
  },
  addCottage: (cottage) => {
    return axios.post(`${process.env.REACT_APP_API_URL}cottages`, cottage);
  },
  deleteCottage: (cottageID) => {
    return axios.delete(
      `${process.env.REACT_APP_API_URL}cottages/${cottageID}`
    );
  },
  updateCottage: (cottage) => {
    return axios.put(
      `${process.env.REACT_APP_API_URL}cottages/${cottage.id}`,
      cottage
    );
  },
  getCottagesByOwner: (cottageOwnerId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottagesByOwner?cottageOwnerId=${cottageOwnerId}`
    );
  },
  getCottagesById: (cottageId) => {
    return axios.get(
      `${process.env.REACT_APP_API_URL}cottagesByOwner/${cottageId}`
    );
  },
};

export default cottageServices;
