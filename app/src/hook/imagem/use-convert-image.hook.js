
export function useConvertImage() {

    function convertImageTo64(file) {
      const reader = new FileReader();
      
      return new Promise((resolve, reject) => {
          reader.readAsDataURL(file);
          reader.onerror = function (error) {
            reject(new DOMException("Problem parsing input file."));
          };
          reader.onload = function() {
            resolve(reader.result);
          };
        });
    }
    
    return { convertImageTo64 }
}